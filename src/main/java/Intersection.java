import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Intersection {

    // static Map<String, BanWithUserCount> finalMap = new HashMap(100000);
    static Map<String, BanWithUserCount> first = new ConcurrentHashMap<>(100001);
    static Map<String, BanWithUserCount> second = new ConcurrentHashMap<>(100001);
    public static void main(final String[] args) {

        final ExecutorService service = Executors.newCachedThreadPool();
        
        final Runnable aa = new Runnable() {
			@Override
			public void run() {
                int i = 10;
                while(i > 0) {
                   service.submit(new BanTask(first, ("ban#" + i)));
                   i--;
               }
				
			}
        };


        final Runnable bb = new Runnable() {
			@Override
			public void run() {
                int i = 15;
                while(i > 0) {
                   service.submit(new UserCountTask(second, i, ("ban#" + i)));
                   i--;
               }
				
			}
        };
        aa.run();
        bb.run();


        // Code for intersection

        first.keySet().parallelStream().filter( k -> second.containsKey(k)).collect(Collectors.toList());

//        first.r

        System.out.println("first ::" + first);
        System.out.println("second ::" + second);

    }
}

class BanWithUserCount {
    public String ban;
    public Integer usercount;

    @Override
    public String toString() {
        return "["+ban+"-"+usercount+"]";
    }
}

class BanTask implements Callable {

    private final  String ban;
    private final Map<String, BanWithUserCount> ref;

    public BanTask(final Map<String, BanWithUserCount> ref, final String ban) {
        this.ban = ban;
        this.ref = ref;
    }

	@Override
	public Object call() throws Exception {
        if(this.ref != null && this.ref.get(ban)==null ){
            this.ref.put(ban, new BanWithUserCount());
        }
        this.ref.get(ban).ban = ban;
		return "Y";
	}

}


class UserCountTask implements Callable {

    private final  int usercount;
    private final  String ban;
    private final Map<String, BanWithUserCount> ref;

    public UserCountTask(final Map<String, BanWithUserCount> ref, final int usercount, final String ban) {
        this.usercount = usercount;
        this.ref = ref;
        this.ban = ban;
    }

	@Override
	public Object call() throws Exception {
		if(this.ref != null && this.ref.get(ban)==null) {
            this.ref.put(ban, new BanWithUserCount());
        }
        this.ref.get(ban).ban = ban;
        this.ref.get(ban).usercount = usercount;
		return "Y";
	}

}