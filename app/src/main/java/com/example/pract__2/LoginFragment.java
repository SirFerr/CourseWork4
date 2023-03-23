package com.example.pract__2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class LoginFragment extends Fragment {
    private static final int NOTIFY_ID = 0;
    private final String CHANNEL_ID = "channel_id";
    View view;

    private void showNotification(String title, String text) {
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(getContext(), CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(getContext());
        notificationManager.notify(NOTIFY_ID, builder.build());
        // notificationId - должен быть уникальным для каждого уведомления в канале
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        Toast.makeText(getActivity(), "onCreate", Toast.LENGTH_SHORT).show();
        Log.d("onCreate", "onCreate");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Создание канала уведомлений
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Channel name",
                    NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Channel description");
            NotificationManager notificationManager = getActivity().getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        EditText editText = (EditText) view.findViewById(R.id.editTextTextEmailAddress);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        editText.setText(getResources().getString(R.string.testEmail));
        imageView.setImageResource(R.drawable.cabinetlog);

        Bundle bundle = getArguments();
        if (bundle != null) {
            ((EditText) view.findViewById(R.id.editTextTextEmailAddress)).setText(bundle.getString("email"));
        }
        view.findViewById(R.id.continueBtn).setOnClickListener(v -> {
            Bundle bundle12 = new Bundle();
            bundle12.putString("email", String.valueOf(((EditText) view
                    .findViewById(R.id.editTextTextEmailAddress))
                    .getText()));
            showNotification("Title", "Text");

//                Navigation.findNavController(view).navigate(R.id.action_loginFragment2_to_mainMenuFragment,bundle);
        });
        view.findViewById(R.id.regBtn).setOnClickListener(v -> {
            Bundle bundle1 = new Bundle();
            bundle1.putString("email", String.valueOf(((EditText) view
                    .findViewById(R.id.editTextTextEmailAddress))
                    .getText()));
            Navigation.findNavController(view).navigate(R.id.action_loginFragment2_to_linearFragment, bundle1);
        });

        return view;
    }

}