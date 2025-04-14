package br.fecap.ads.questao1;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Declaração dos elementos da interface (View)
    private CheckBox checkBoxArroz;
    private CheckBox checkBoxLeite;
    private CheckBox checkBoxCarne;
    private CheckBox checkBoxFeijao;
    private CheckBox checkBoxRefrigerante;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Função para calcular o total da compra
    public void calcularTotalCompra(View view) {

        // Vinculando os elementos com os Views
        checkBoxArroz = findViewById(R.id.checkBoxArroz);
        checkBoxLeite = findViewById(R.id.checkBoxLeite);
        checkBoxCarne = findViewById(R.id.checkBoxCarne);
        checkBoxFeijao = findViewById(R.id.checkBoxFeijao);
        checkBoxRefrigerante = findViewById(R.id.checkBoxRefrigerante);
        textResultado = findViewById(R.id.textResultado);

        // Variavel total de compra do cliente
        double totalCompra = 0.00;

        // Variaveis com os valores dos itens de compra
        double valorArroz = 2.69;
        double valorLeite = 5.00;
        double valorCarne = 10.00;
        double valorFeijao = 2.30;
        double valorRefrigerante = 2.00;

        // Verifica se algum item foi selecionado
        if (!checkBoxArroz.isChecked() && !checkBoxLeite.isChecked() && !checkBoxCarne.isChecked() && !checkBoxFeijao.isChecked() && !checkBoxRefrigerante.isChecked()) {
            Toast.makeText(this, "Escolha um item para comprar", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verificação se o checkBox do Arroz foi marcado
        if (checkBoxArroz.isChecked()) {
            totalCompra += valorArroz; // Soma o valor do arroz com o total do cliente
        }

        // Verificação se o checkBox do Leite foi marcado
        if (checkBoxLeite.isChecked()) {
            totalCompra += valorLeite; // Soma o valor do leite com o total do cliente
        }

        // Verificação se o checkBox da Carne foi marcado
        if (checkBoxCarne.isChecked()) {
            totalCompra += valorCarne; // Soma o valor do carne com o total do cliente
        }

        // Verificação se o checkBox da Feijão foi marcado
        if (checkBoxFeijao.isChecked()) {
            totalCompra += valorFeijao; // Soma o valor do feijão com o total do cliente
        }

        // Verificação se o checkBox do Refrigerante foi marcado
        if (checkBoxRefrigerante.isChecked()) {
            totalCompra += valorRefrigerante; // Soma o valor do refrigerante com o total do cliente
        }

        // Exibe o resultado do total de compra com formatação de duas casas decimais
        textResultado.setText(String.format("O total da sua compra foi R$ %.2f", totalCompra));


    }
}