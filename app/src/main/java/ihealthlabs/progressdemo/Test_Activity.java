package ihealthlabs.progressdemo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Window;

public class Test_Activity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_test);
    }
}
