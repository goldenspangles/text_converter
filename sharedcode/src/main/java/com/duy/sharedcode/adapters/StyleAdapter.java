/*
 * Copyright (c) 2017 by Tran Le Duy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duy.sharedcode.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duy.sharedcode.ClipboardUtil;
import com.duy.sharedcode.ShareManager;
import com.duy.textconverter.sharedcode.R;

import java.util.ArrayList;


public class StyleAdapter extends RecyclerView.Adapter<StyleAdapter.ViewHolder> {
    private final Activity context;
    private LayoutInflater inflater;
    private ArrayList<String> mList = new ArrayList<>();

    public StyleAdapter(Activity context) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void add(String arg) {
        mList.add(arg);
        notifyItemInserted(mList.size() - 1);
    }

    public void setData(ArrayList<String> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.list_item_style, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String str = mList.get(position);
        holder.textView.setText(mList.get(position));
        holder.imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareManager.share(str, context);
            }
        });
        holder.imgCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardUtil.setClipboard(context, str);
            }
        });
        holder.shareMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShareManager.shareMessenger(str, context);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        View imgCopy, imgShare, shareMsg;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            imgCopy = itemView.findViewById(R.id.img_copy);
            imgShare = itemView.findViewById(R.id.img_share);
            shareMsg = itemView.findViewById(R.id.img_share_msg);
        }
    }
}