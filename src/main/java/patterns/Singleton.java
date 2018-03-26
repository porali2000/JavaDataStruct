package patterns;

public enum Singleton {
    INSTANCE;

    public void singletonmethod(){
        System.out.println("running inside singleton  method");
    }

    public void singletonmethod(String name){
        System.out.println("running inside singleton  method with "+name);
    }
}
