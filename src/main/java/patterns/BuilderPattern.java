package patterns;

public class BuilderPattern {

    public static class Builder {

        public Builder withName(final String name){
            this.name = name;
            return this;
        }

        public BuilderPattern build(){
            return new BuilderPattern(this.name,this.type);
        }


        private  String name;
        private String type = "worker";
    }


    public  String name;
    public String type = "worker";


    private BuilderPattern(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
