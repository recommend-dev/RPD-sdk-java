package co.recommend;

public class App {
    public static void main(String[] args) {
        try {
            SDK sdk = new SDK("your-api-key", "");
            System.out.println(sdk.TestConnection());

            System.out.println(sdk.ReferralCheck("valid-referral-code", "", "", "", "", ""));

            System.out.println(sdk.ApproveConversion(1));
            System.out.println(sdk.ApproveConversion(1));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
