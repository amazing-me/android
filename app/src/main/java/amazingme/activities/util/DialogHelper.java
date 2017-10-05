package amazingme.activities.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;

public class DialogHelper {

    public static AlertDialog.Builder getInfoDialog(final Activity activity, final String title, final Runnable fn) {
        final AlertDialog.Builder alertDialog;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            alertDialog = new AlertDialog.Builder(activity, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            alertDialog = new AlertDialog.Builder(activity);
        }

        alertDialog.setTitle(title)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        dialog.dismiss();
                        if(fn != null) {
                            fn.run();
                        }
                    }
                });

        return alertDialog;
    }

    //TODO -> generalize this to take some kind of enumerated dialog to build, so it's more generic
    public static AlertDialog.Builder getAlertDialog(final Activity activity, final String title) {
        final AlertDialog.Builder alertDialog;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            alertDialog = new AlertDialog.Builder(activity, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            alertDialog = new AlertDialog.Builder(activity);
        }
        alertDialog.setTitle(title)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        dialog.dismiss();
                    }
                });

        return alertDialog;
    }

}
