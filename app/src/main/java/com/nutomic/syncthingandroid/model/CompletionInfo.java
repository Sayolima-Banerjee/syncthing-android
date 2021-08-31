package com.nutomic.syncthingandroid.model;

/**
 * According to syncthing REST API
 * https://docs.syncthing.net/rest/db-completion-get.html
 *
 * completion is also returned by the events API
 * https://docs.syncthing.net/events/foldercompletion.html
 *
 */
public class CompletionInfo {
    public double completion = 100;
    
    NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
        .setSmallIcon(R.drawable.notification_icon)
        .setContentTitle("Files Synchronization Complete")
        .setContentText("All your files have successfully synchronized !")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    
    
Intent intent = new Intent(this, AlertDetails.class);
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
        .setSmallIcon(R.drawable.notification_icon)
        .setContentTitle("Files Synchronization Complete")
        .setContentText("All your files have successfully synchronized !")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
       
        .setContentIntent(pendingIntent)
        .setAutoCancel(true);

    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

notificationManager.notify(0001, builder.build());
    
    /**
     * The following values are only returned by the REST API call
     * to ""/completion". We will need them in the future to show
     * more statistics in the device UI.
     */
    // public long globalBytes = 0;
    // public long needBytes = 0;
    // public long needDeletes = 0;
    // public long needItems = 0;
}
