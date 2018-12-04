public class Entity {

//    private static final int i = 0;
//    private String s;
    private int m;

    public Entity(){
    }

    public Entity(String s, int m){
        this.m = m;
        //this.s = s;
    }
    @Secured(name = 1)
    public synchronized  String someMethod(Boolean s, int i){
        System.out.println("this is " + s + " and " + i);
        return someMethod(s, i);
    }
    @Secured(name = 2, type = "notStrict")
    private void second(int f) {

    }


}
