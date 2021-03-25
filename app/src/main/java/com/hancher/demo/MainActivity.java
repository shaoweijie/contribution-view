package com.hancher.demo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hancher.contribution.ContributionConfig;
import com.hancher.contribution.ContributionItem;
import com.hancher.contribution.ContributionView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContributionView contributionView = findViewById(R.id.contributionView);

        List<ContributionItem> data = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 3 - 1, 1);
        Date startDate = calendar.getTime();
        for (int i = 0; i < 150; i++) {
            data.add(new ContributionItem(calendar.getTime(), i % 10));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        ContributionConfig config = new ContributionConfig()
                .setBorderWidth(2)
                .setBorderColor(0xFF9E9E9E)
                .setItemRound(5)
                .setMonths(new String[]{"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"})
                .setPadding(4)
                .setRank(new int[]{0, 2, 5, 8, 10})
                .setRankColor(new int[]{0xFFEBEDF0, 0xFF9BE9A8, 0xFF40C463, 0xFF30A14E, 0xFF216E39})
                .setWeeks(new String[]{"", "周一", "", "周三", "", "周五", ""})
                .setStartOfWeek(Calendar.SUNDAY)
                .setTxtColor(0xFFFF0000);

        contributionView.setData(startDate, data, config);

        contributionView.setOnItemClick(new ContributionView.OnItemClickListener() {
            @Override
            public void onClick(int position, ContributionItem item) {
                Toast.makeText(MainActivity.this, position + ":" + item.getRow() + "," + item.getCol(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}