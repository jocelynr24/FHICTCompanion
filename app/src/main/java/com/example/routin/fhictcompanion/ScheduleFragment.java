package com.example.routin.fhictcompanion;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TableLayout;

import com.example.routin.adapter.ScheduleAdapter;
import com.example.routin.api.ScheduleApi;
import com.example.routin.dto.ScheduleMeRoot;

public class ScheduleFragment extends Fragment {
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.schedule_layout, container, false);
        final View self = myView;
        new ScheduleApi(){
            @Override
            protected void onPostExecute(ScheduleMeRoot result) {
                if (result != null && result.getData() != null) {
                    ScheduleAdapter adapter = new ScheduleAdapter(getActivity(), R.layout.schedule_row, result.getData());
                    ((ListView) self.findViewById(R.id.schedulelist)).setAdapter(adapter);
                }
            }
        }.execute(TokenSingleton.getInstance().getToken());
        return myView;
    }
}
