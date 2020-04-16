package mr.booroondook.viewpager_and_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class PagerFragment extends Fragment {
    private static final String KEY_POSITION = "position";

    private String[] lastNames;

    private PagerFragment() {}

    static PagerFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt(KEY_POSITION, position);
        PagerFragment fragment = new PagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lastNames = getResources().getStringArray(R.array.last_names);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_fragment, container, false);

        TextView unitName = view.findViewById(R.id.unit_name);
        TextView unitStatus = view.findViewById(R.id.unit_status);
        ImageView iconStatus = view.findViewById(R.id.icon_status);
        int position = Objects.requireNonNull(getArguments()).getInt(KEY_POSITION, -1);
        unitName.setText(lastNames[position]);
        if (lastNames[position].length() % 2 == 0) {
            unitStatus.setText(R.string.adopted);
            iconStatus.setImageResource(R.drawable.ic_check_24dp);
        } else {
            unitStatus.setText(R.string.fired);
            iconStatus.setImageResource(R.drawable.ic_close_24dp);
        }
        return view;
    }
}
