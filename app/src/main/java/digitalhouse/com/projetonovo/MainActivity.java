package digitalhouse.com.projetonovo;


//import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v4.app.Fragment;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = (Button) findViewById(R.id.button1);

        // Pega o FragmentManager
        fragmentManager = getSupportFragmentManager();

        //Abre uma transação e adiciona
        fragmentManager.beginTransaction()
                .add(R.id.frame1, new Fragmento1())
                .commit();

        fragmentManager.beginTransaction()
                .add(R.id.frame2, new Fragmento2())
                .commit();

        fragmentManager.beginTransaction()
                .replace(R.id.frame1, new Fragmento1())
                .addToBackStack(null)
                .commit();

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame2);
                if(fragment != null) {
                    fragmentManager.beginTransaction().remove(fragment).commit();
                    Toast.makeText(v.getContext(), "Você esta no Fragment 2", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
