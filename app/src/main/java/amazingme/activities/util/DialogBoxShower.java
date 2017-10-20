package amazingme.activities.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;

public class DialogBoxShower {

    private static final int INFO_DIALOG_ID = android.R.drawable.ic_dialog_info;
    private static final int ALERT_DIALOG_ID = android.R.drawable.ic_dialog_alert;

    public static void show(final DialogType dialogType, final Activity context, final String title,
                            final String message, final Runnable fn) {

        final DialogBuilder builder = new DialogBuilder();
        final AlertDialog.Builder dialog = builder.buildDialog(context, title, fn, dialogType.iconId);
        dialog.setMessage(message);
        dialog.show();
    }

    public enum DialogType {
        ALERT_DIALOG(ALERT_DIALOG_ID),
        INFO_DIALOG(INFO_DIALOG_ID);

        private int iconId;

        DialogType(int iconId) { this.iconId = iconId; }
    }

    private static class DialogBuilder {

        private final int DIALOG_THEME = android.R.style.Theme_Material_Dialog_Alert;

        private AlertDialog.Builder buildDialog(final Activity activity, final String title, final Runnable fn,
                                                final int dialogId) {
            final AlertDialog.Builder alertDialog;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                alertDialog = new AlertDialog.Builder(activity, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                alertDialog = new AlertDialog.Builder(activity);
            }

            alertDialog.setTitle(title)
                    .setIcon(dialogId)
                    .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(final DialogInterface dialog, final int which) {
                            setNegativeButtonFunction(dialog, fn);
                        }
                    });

            return alertDialog;
        }

        private void setNegativeButtonFunction(final DialogInterface dialog, final Runnable function) {
            dialog.dismiss();
            if (function != null) {
                function.run();
            }
        }

    }

}