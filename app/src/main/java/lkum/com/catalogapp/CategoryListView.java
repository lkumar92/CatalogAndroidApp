package lkum.com.catalogapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class CategoryListView extends AppCompatActivity {

    FirebaseFirestore dbRef = FirebaseFirestore.getInstance();
    private ArrayList<Category> categoryList = new ArrayList<>();
    ListView catListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_list_view);
        catListView = (ListView)findViewById(R.id.categoryListView);
        /*DocumentReference docRef = dbRef.collection("category").document("10001");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Category category = documentSnapshot.toObject(Category.class);
                categoryList.add(category);
                ListView catListView = (ListView)findViewById(R.id.categoryListView);
                CategoryListAdapter catListAdapter = new CategoryListAdapter(getApplicationContext(),categoryList);
                catListView.setAdapter(catListAdapter);
            }
        });*/
        dbRef.collection("category").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                categoryList.clear();
                for (DocumentSnapshot snapshot : documentSnapshots){
                    Category category = snapshot.toObject(Category.class);
                    categoryList.add(category);
                }
                //catListView = (ListView)findViewById(R.id.categoryListView);
                CategoryListAdapter catListAdapter = new CategoryListAdapter(getApplicationContext(),categoryList);
                catListView.setAdapter(catListAdapter);
            }
        });

        catListView.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                Category category = categoryList.get(position);
                Long categoryId = category.getId();
                Toast.makeText(CategoryListView.this, categoryId.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void toCategoryPage(View v) {

        Intent myIntent = new Intent(CategoryListView.this,
                CategoryPage.class);
        startActivity(myIntent);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

}
