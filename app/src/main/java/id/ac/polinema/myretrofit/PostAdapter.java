package id.ac.polinema.myretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private Context context;
    private List<Post> items;

    public PostAdapter(Context context, List<Post> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_mahasiswa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.TextNama.setText(items.get(position).getNama());
        holder.TextId.setText("ID Mahasiswa : " + items.get(position).getId_siswa());
        holder.TextAlamat.setText("Alamat : " + items.get(position).getAlamat());
        holder.TextJk.setText("Jenis Kelamin : " + items.get(position).getJenis_kelamin());
        holder.TextTelepon.setText("Telepon : " + items.get(position).getNo_telp());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView TextId;
        TextView TextNama;
        TextView TextAlamat;
        TextView TextJk;
        TextView TextTelepon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TextId = itemView.findViewById(R.id.txt_id);
            TextNama = itemView.findViewById(R.id.txt_nama);
            TextAlamat = itemView.findViewById(R.id.txt_alamat);
            TextJk = itemView.findViewById(R.id.txt_jk);
            TextTelepon = itemView.findViewById(R.id.txt_no_telp);
        }
    }
}
