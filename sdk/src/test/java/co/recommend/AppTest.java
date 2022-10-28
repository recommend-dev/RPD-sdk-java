package co.recommend;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class AppTest 
{
    @Test
    public void CheckConnectionShouldFail()
    {
        try {
            SDK sdk = new SDK("your-api-key", "");
            boolean result = sdk.TestConnection();
            assertFalse( result );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
