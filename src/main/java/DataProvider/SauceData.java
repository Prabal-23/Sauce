package DataProvider;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class SauceData {


    @DataProvider(name = "SauceValidAll")
    public Object[][] getProductionData() {
        // Define usernames and a common password
        String[] usernames = {
                "standard_user",
                "locked_out_user",
                "problem_user",
                "performance_glitch_user",
                "error_user",
                "visual_user"
        };
        String password = "secret_sauce";

                  Object[][] data = new Object[usernames.length][2];

            for (int i = 0; i < usernames.length; i++) {
            data[i][0] = usernames[i];
            data[i][1] = password;
        }

        return data;
    }

    @DataProvider(name = "SauceInvalidpassword")
    public Object[][] getLoginCred() {
        // Define usernames and a common password
        String[] usernames = {
                "standard_user",
                "locked_out_user",
                "problem_user",
                "performance_glitch_user",
                "error_user",
                "visual_user"
        };
        String password = "my_secure";

        Object[][] data = new Object[usernames.length][2];

        for (int i = 0; i < usernames.length; i++) {
            data[i][0] = usernames[i];
            data[i][1] = password;
        }

        return data;
    }



}
