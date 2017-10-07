package com.example.routin.fhictcompanion;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.routin.adapter.CanvasAdapter;
import com.example.routin.api.CanvasApi;
import com.example.routin.dto.CanvasMe;

import java.util.ArrayList;

public class CanvasFragment extends Fragment {
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.canvas_layout, container, false);
        final View self = myView;
        new CanvasApi(){
            @Override
            protected void onPostExecute(ArrayList<CanvasMe> result) {
                if (result != null) {
                    CanvasAdapter adapter = new CanvasAdapter(getActivity(), R.layout.canvas_row, result);
                    ((ListView) self.findViewById(R.id.canvaslist)).setAdapter(adapter);
                }
            }
        }.execute(TokenSingleton.getInstance().getToken());
        return myView;
    }
}
