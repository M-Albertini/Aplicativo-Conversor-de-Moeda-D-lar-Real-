# Conversor de Moeda

Atividade de compensação de ausência da disciplina de Desenvolvimento de Aplicativos Móveis.

O aplicativo faz a conversão entre dólar e real usando uma cotação fixa de **1 dólar = 5 reais**. A tela tem dois campos para digitar os valores e dois botões, um para cada sentido da conversão.

## O que foi utilizado

- Kotlin e Jetpack Compose.
- `Surface` para a superfície da tela.
- `Column` para organizar os textos e os campos na vertical.
- `Row` para colocar os dois botões lado a lado.
- `Text` para o título, os rótulos e a cotação.
- Dois componentes `TextField` e dois componentes `Button`.
- `remember` e `mutableStateOf` para armazenar e atualizar os valores dos campos.

## Como funciona

A cotação fica definida no código pela variável `cotacao`, com o valor `5.0`.

No botão **Converter para Real**, o valor digitado em dólar é multiplicado pela cotação. O resultado aparece no campo de real.

No botão **Converter para Dólar**, o valor digitado em real é dividido pela cotação. O resultado aparece no campo de dólar.

Os campos armazenam texto. Por isso, antes do cálculo, o texto é convertido para número com `toDoubleOrNull()`. O `replace(',', '.')` permite digitar a parte decimal com vírgula ou ponto. Se o campo estiver vazio ou não contiver um número válido, o botão não altera o outro campo.

O resultado usa `toString()`, então pode aparecer como `50.0`, sem formatação especial de moeda. A proposta é demonstrar a conversão básica.

## Como executar no Android Studio

Este repositório contém o arquivo principal solicitado na atividade, e não um projeto Android completo.

1. No Android Studio, crie um projeto **Empty Activity**, com Kotlin e Jetpack Compose. Não escolha o modelo de interface baseado em Views/XML.
2. Use `com.example.conversormoeda` como nome do pacote. Se usar outro pacote, ajuste a primeira linha do arquivo `MainActivity.kt` para corresponder ao seu projeto.
3. Substitua o conteúdo do `MainActivity.kt` criado pelo Android Studio pelo conteúdo deste arquivo.
4. Aguarde a sincronização do Gradle.
5. Execute o aplicativo em um emulador ou celular Android.

Os imports `androidx.compose.material3` dependem do Material 3, normalmente já incluído no modelo Empty Activity com Compose.
