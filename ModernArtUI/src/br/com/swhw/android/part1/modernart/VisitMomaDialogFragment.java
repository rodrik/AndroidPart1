package br.com.swhw.android.part1.modernart;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class VisitMomaDialogFragment extends DialogFragment {
	
	private static final String URL = "http://www.moma.org";
	
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
    	
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_text)
               .setPositiveButton(R.string.button_visitmoma, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(URL)));
                   }
               })
               .setNegativeButton(R.string.button_notnow, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       // User cancelled the dialog
                	   dismiss();
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}