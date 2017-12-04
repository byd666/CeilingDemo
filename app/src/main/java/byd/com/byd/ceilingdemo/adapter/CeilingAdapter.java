package byd.com.byd.ceilingdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import byd.com.byd.ceilingdemo.R;
import byd.com.byd.ceilingdemo.bean.CeilingBean;

/**
 * @author：byd666 on 2017/12/2 15:19
 */
public class CeilingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    /**头视图*/
    public static final int TYPE_HEADER = 0;
    /**正常的*/
    public static final int TYPE_NORMAL = 1;

    private View mHeaderView;

    private Context context;
    private List<CeilingBean.BaseBean> stickyExampleModels;

    public CeilingAdapter(Context context, List<CeilingBean.BaseBean> recyclerViewModels) {
        this.context = context;
        this.stickyExampleModels = recyclerViewModels;
    }
    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mHeaderView != null && viewType == TYPE_HEADER)
        {
            return new HeaderViewHolder(mHeaderView);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.scrolling_item_layout, parent, false);
        return new HomeRecyclerViewHolder(view);
    }
    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return mHeaderView;
    }

    @Override
    public int getItemViewType(int position) {
        if(mHeaderView == null){ return TYPE_NORMAL;}
        if(position == 0) {return TYPE_HEADER;}
        return TYPE_NORMAL;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if(getItemViewType(position) == TYPE_HEADER){ return;}
        final int pos = getRealPosition(viewHolder);
        if (viewHolder instanceof HomeRecyclerViewHolder) {
            HomeRecyclerViewHolder holder = (HomeRecyclerViewHolder) viewHolder;
            holder.setData(pos);
            if(mListener == null){ return;}
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(pos);
                }
            });
        }
    }
    public int getRealPosition(RecyclerView.ViewHolder holder) {
        return holder.getLayoutPosition();
    }

    @Override
    public int getItemCount() {
        return stickyExampleModels == null ? 0 : stickyExampleModels.size();
    }

    public class HomeRecyclerViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public HomeRecyclerViewHolder(View itemView) {
            super(itemView);
            tvName= (TextView) itemView.findViewById(R.id.tv_name);
        }
        public void setData(int position) {
            CeilingBean.BaseBean bean = stickyExampleModels.get(position);
            if(bean instanceof CeilingBean.ResultBean.FirstBean)
            {
                //分类一
                CeilingBean.ResultBean.FirstBean bean1 = (CeilingBean.ResultBean.FirstBean) bean;
                tvName.setText(bean1.getgName());

            }else if(bean instanceof CeilingBean.ResultBean.SecondBean){
                //分类二
                CeilingBean.ResultBean.SecondBean bean2 = (CeilingBean.ResultBean.SecondBean) bean;
                tvName.setText(bean2.getgName());

            }else if(bean instanceof CeilingBean.ResultBean.ThirdBean){
                //分类三
                CeilingBean.ResultBean.ThirdBean bean3 = (CeilingBean.ResultBean.ThirdBean) bean;
                tvName.setText(bean3.getgName());

            }
        }
    }
    public class HeaderViewHolder extends RecyclerView.ViewHolder{
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}

