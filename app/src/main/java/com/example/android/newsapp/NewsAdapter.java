package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    private static final String DATE_SEPARATOR = "T";

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);

        TextView topicView = listItemView.findViewById(R.id.tv_topic);
        TextView titleView = listItemView.findViewById(R.id.tv_title);
        TextView dateView = listItemView.findViewById(R.id.tv_date);
        TextView timeView = listItemView.findViewById(R.id.tv_time);
        TextView authorView = listItemView.findViewById(R.id.tv_author);

        topicView.setText(currentNews.getTopic());
        titleView.setText(currentNews.getTitle());
        authorView.setText(currentNews.getAuthor());

        String datePart, timePart;
        String combinedDate = currentNews.getDate();
        String[] parts = combinedDate.split(DATE_SEPARATOR);
        datePart = parts[0];
        timePart = parts[1];

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:sss");

        try {
            Date date = dateFormatter.parse(datePart);
            Date time = timeFormatter.parse(timePart);

            dateView.setText(formatDate(date));
            timeView.setText(formatTime(time));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date timeObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        return timeFormat.format(timeObject);
    }
}