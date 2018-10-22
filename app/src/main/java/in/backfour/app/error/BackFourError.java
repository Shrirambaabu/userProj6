package in.backfour.app.error;

import android.util.Log;

import java.io.IOException;

public class BackFourError extends IOException {
    private static final String TAG = "HMCError";
    private int responseCode;
    private String message;

    BackFourError(int responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
        Log.e(TAG, "BackFourError: " + message + " code " + responseCode);
    }

    public int getResponseCode() {
        return responseCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
