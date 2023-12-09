public class CheckedUnchekedEx {
    public static void main(String[] args) {

        try {
            int a = 1/0;
        }catch (RuntimeException e){
            System.out.println(1/0);
        }
    }
}
