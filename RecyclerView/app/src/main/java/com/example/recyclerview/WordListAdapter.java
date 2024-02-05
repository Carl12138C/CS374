package com.example.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordItemView;
        final WordListAdapter mAdapter;
        public WordViewHolder(View itemView, WordListAdapter adapter){
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }
        public void onClick(View view){
            int mPosition = getLayoutPosition();
            String element = mWordList.get(mPosition);
            mWordList.set(mPosition,"Clicked! " + element);
            mAdapter.notifyDataSetChanged();
        }
    }
    public WordListAdapter(Context context, LinkedList<String> wordList){
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }
    public WordListAdapter.WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,parent,false);
        return new WordViewHolder(mItemView,this);
    }

    public void onBindViewHolder( WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    public int getItemCount() {
        return mWordList.size();
    }
}