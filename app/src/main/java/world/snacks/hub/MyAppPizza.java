package world.snacks.hub;

import android.content.Context;

import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.vungle.warren.InitCallback;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;

public class MyAppPizza {


    public static void initialize_ads(Context app_context, String vungle_app_id, String start_app_id){
        MobileAds.initialize(app_context);
        AudienceNetworkAds.initialize(app_context);
        Vungle.init(vungle_app_id, app_context.getApplicationContext(), new InitCallback() {
            @Override
            public void onSuccess() {
                MyLog.e("Vungle.init onSuccess", "init");

            }

            @Override
            public void onError(VungleException exception) {

                MyLog.e("Vungle.init exception", "init= " + exception.toString());
            }

            @Override
            public void onAutoCacheAdAvailable(String placementId) {
            }
        });


        AdSettings.setTestMode(false);

    }


}
