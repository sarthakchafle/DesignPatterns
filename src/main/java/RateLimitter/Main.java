package RateLimitter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimitter rateLimitter = new RateLimitter(5,3);
        String userid="user1";
        for(int i=0;i<=1500;i++){
            if(rateLimitter.isRequestAllowed(userid)){
                System.out.println("allowed");
            }else{
                System.out.println("rejected");
            }
            System.out.println("tokens= "+rateLimitter.getTokenCount(userid));
            Thread.sleep(30);
        }

    }


}
