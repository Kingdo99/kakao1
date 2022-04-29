package org.techtown.kakao1
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(val profileList : ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        //list아이템을 붙이는 작업
        //어뎁터와 연결될 액티비티의 모든 정보 가져옴 = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        //inflate로 붙이다 listitem을 parent에
        return CustomViewHolder(view)
        // cusTomViewHolder, parent에 listitem 붙인 뷰를 매개변수로 호출
    }
    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        //위에 만들어 놓은 customView홀더를 안정적으로 매칭시켜 주는 곳
        holder.profile.setImageResource(profileList.get(position).profile)
        // 미리 준비되어 있는 데이터 profilelist에 있는 데이터를
        //holder를 통해 구격(list_item)에 맞게 각각의 데이터를 매칭시켜준 뒤 holder에 포현
        holder.name.text = profileList.get(position).name
    }

    override fun getItemCount(): Int {
        //list 데이터의 개수
        return profileList.size
    }

    class CustomViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        //View 타입의 itmeView를 매개변수로 받아서 customViewHolder를 실행시키면
        //RecyclerView에 있는 ViewHolder 생성자에 ItemView를 매개변수로 주고 생성
        val profile  =  itemView.findViewById<ImageView>(R.id.iv_profile)
        val name  =  itemView.findViewById<TextView>(R.id.tv_name)
        //holder의 매개변수로 줄 즉 미리 만들어 놓은 구격의 뷰 아이디 값을 바인딩



    }
}