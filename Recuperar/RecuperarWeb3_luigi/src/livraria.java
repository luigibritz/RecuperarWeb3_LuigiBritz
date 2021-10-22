import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class livraria {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        ArrayList<Livros> livros = new ArrayList<Livros>();

        int escolha = 0;
        int repetir = 1;
        int dnv = 1;

        String usuarioAdmin = "admin";
        String senhaAdmin = "admin"; 

        String usuario;
        String senha;

        boolean autenticado = false;

        String titulo;
        int preco;
        String editora;
        String categoria;
        String status;
        int codigo;

        System.out.println("==================================");
        System.out.println("Digite seu usário:");
        usuario = ler.nextLine();
        System.out.println("Digite a sua senha: ");
        senha = ler.nextLine();
        System.out.println("==================================");
        while(autenticado == false){
            if((!usuario.equals(usuarioAdmin) || (!senha.equals(senhaAdmin))))
            {
                System.out.println("==================================");
                System.out.println("Tente novamente, digite seu usuário:");
                usuario = ler.nextLine();

                System.out.println("Digite a sua senha: ");
                senha = ler.nextLine();
                System.out.println("==================================\n\n\n\n");

            }
            else {
                System.out.println("Você esta logado\n\n\n\n");

                
                autenticado = true;
                break;
            }
        }


        if(autenticado == true){
            System.out.println("Logou no sistema\n\n");
            while(repetir == 1){
                System.out.println("Escolha uma opção:\n\n");
                System.out.println("1: Buscar livro\n2: Cadastrar livro\n3: Emprestar livro\n4: Devolver livro\n5: Listar livros\n6: Sair");
                escolha = ler.nextInt();
                switch(escolha){
                    case 1:
                    System.out.println("\nDigite o título do livro:\n\n");
         
                    case 2:
                    while(dnv==1){
                        System.out.println("\nDigite o título do livro:\n\n");
                        titulo = ler.next();
                        System.out.println("\nDigite o preço do livro:\n\n");
                        preco = ler.nextInt();
                        System.out.println("\nDigite a editora do livro:\n\n");
                        editora = ler.next();
                        System.out.println("\nDigite a categoria livro:\n");
                        System.out.println("\nApenas as categorias: Ação, Romance, Ficção, História e Técnico\n\n");
                        categoria = ler.next();
                        while(repetir==1){
                            if(categoria != "Ação" || categoria != "Romance" || categoria != "Ficção" || categoria != "História"|| categoria != "Técnico"){
                                System.out.println("\nDigite novamente\nApenas as categorias: Ação, Romance, Ficção, História e Técnico\n\n");
                                categoria = ler.next();
                                repetir = 1;
                            }
                            else  System.out.println("ELSEEEEEEEE");
                           
                        }
                     
                        status = "Disponível";
                        System.out.println("\nDigite o código do livro:\n\n");
                        codigo = ler.nextInt();
                        livros.add(new Livros(titulo, preco, editora, categoria, status, codigo));
                        System.out.println("\n\n\nDeseja adicionar um novo livro?");
                        System.out.println("1 para adicionar outro livro ou 0 para sair");
                        dnv = ler.nextInt();
                    }
                 
                    
                    break;
                    case 3:

                    case 4:
                    System.out.println("\nDigite qual o código do livro que você quer emprestar\n");
                    int codigoEmprestar = ler.nextInt();
                    codigoEmprestar = codigoEmprestar - 4;
                    System.out.println(livros.get(codigoEmprestar));
                    

                    for(Livros livro : livros){
                        
                    }


                    break;
                    case 5: System.out.println(livros.toString()); break;
    
                    case 6: break;
                    default: break;
                }
                System.out.println("\nEscolher outra opção?\n\n 1 - Escolher outra opção\n 2 - Sair do programa");
                repetir = ler.nextInt();
            }
         
        }
        
    }

}

class Livros {
    private String titulo;
    private int preco;
    private String editora;
    private String categoria;
    private String status;
    private int codigo;

    public Livros(String titulo, int preco, String editora, String categoria, String status, int codigo){
    this.titulo = titulo;
    this.preco = preco;
    this.editora = editora;
    this.categoria = categoria;
    this.status = status;
    this.codigo = codigo;
    
    }

    //getters
public String getTitulo(){
    return this.titulo;
}

public int getPreco(){
    return this.preco;
}

public String getEditora(){
    return this.editora;
}

public String getCategoria(){
    return this.categoria;
}

public String getStatus(){
    return this.status;
}

public int getCodigo(){
    return this.codigo;
}

//setters

public void setTitulo(String titulo){
    this.titulo = titulo;
}

public void setPreco(int preco){
    this.preco = preco;
}
public void setEditora(String editora){
    this.editora = editora;
}
public void setCategoria(String categoria){
    this.categoria = categoria;
}
public void setStatus(String status){
    this.status = status;
}
public void setCodigo(int codigo){
    this.codigo = codigo;
}

public String toString(){
    String texto = "";
    texto = texto + "\nTítulo: " + this.titulo +"\n";
    texto = texto + String.format("\nPreço R$ %.2f \n", this.preco);
    texto = texto + "Editora: " + this.editora +"\n";
    texto = texto + "Categoria: " + this.categoria +"\n";
    texto = texto + "Status: " + this.status +"\n";
    texto = texto + "Código: " + this.codigo +"\n";
    return texto;
}

}





