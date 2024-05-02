//package com.example.mezbaan;
//
//import android.annotation.SuppressLint;
//import android.database.Cursor;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
//    private Cursor cursor;
//
//    public FoodAdapter(Cursor cursor) {
//        this.cursor = cursor;
//    }
//
//    @Override
//    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_food, parent, false);
//        return new FoodViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull FoodAdapter.FoodViewHolder holder, int position) {
//        String itemData;
//
//        if (!cursor.moveToPosition(position)) {
//            return;
//            @SuppressLint("Range")
//             String itemId = cursor.getString(cursor.getColumnIndex("Item_Id"));
//            String itemName = cursor.getString(cursor.getColumnIndex("Item_Name"));
//            String categoryId = cursor.getString(cursor.getColumnIndex("Category_Id"));
//            String itemPrice = cursor.getString(cursor.getColumnIndex("Item_Price"));
//            String itemDescription = cursor.getString(cursor.getColumnIndex("Item_Description"));
//
//            itemData = itemId + "||" + itemName + "||" + categoryId + "||" + itemPrice + "||" + itemDescription;
//            holder.bindData(itemData);
//
//        }
//
//        @Override
//        public int getItemCount () {
//            return cursor.getCount();
//        }
//
//
//        public class FoodViewHolder extends RecyclerView.ViewHolder {
//            TextView textView;
//
//
//            public FoodViewHolder(View itemView) {
//                super(itemView);
//                textView = itemView.findViewById(R.id.text_view);
//            }
//
//            public void bindData (String itemData){
//                textView.setText(itemData);
//            }
//        }
//    }
//}
