
package batalha_naval;

import java.util.Scanner;


public class Batalha_naval {
        static String [][] jogo = new String [10][10];
        static final String SIMBOLO = "N";
        static final String SIMBOLO2 = "C";
        static int cx,cy,disparo,pontuacaoNavio,pn, pontuacaoCanhao,pc, qtdNavio; 
        static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("ola Jogador");
        System.out.println("Estou carregando o jogo... Aguarde.");
        
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                jogo[i][j] = " ";
            }
        }
        
        System.out.println("Jogo carregado.");
        //simbolo = "n";
        
        
        //disparo = disparo;
        //x= acerto nos navios, o= tiro acertados na água
        
        System.out.println("Quantidade de navios: ");
        qtdNavio = scan.nextInt();
        
        System.out.println("Valor de cada navio");
        pn = scan.nextInt();
        pontuacaoNavio = 0;
        
        for (int i = 0; i < qtdNavio ; i++) {
            int t1 = (int) (Math.random() * 10);
            int t2 = (int) (Math.random() * 10);
            while(!jogo[t1][t2].equals(" ")){
                 t1 = (int) (Math.random() * 10);
                 t2 = (int) (Math.random() * 10);
            
            }
            
            jogo[t1][t2] = SIMBOLO;
        }
        
        System.out.println("Quantidade de canhoes: ");
        int qtd = scan.nextInt();
        
        System.out.println("Valor de cada canhao");
        pc = scan.nextInt();
        pontuacaoCanhao = 0;
                
        for (int i = 0; i < qtd ; i++) {
            int t1 = (int) (Math.random() * 10);
            int t2 = (int) (Math.random() * 10);
            while(!jogo[t1][t2].equals(" ")){
                 t1 = (int) (Math.random() * 10);
                 t2 = (int) (Math.random() * 10);
            
            }
            
            jogo[t1][t2] = SIMBOLO2;
        }
        
        
        System.out.println("Quantos disparos deseja realizar ?");
        disparo = scan.nextInt();
        
        for (int i=0; i<disparo;i++){
            String [] bag = new String [disparo];
            System.out.println("Usuario onde desejar jogar ?");
            cx = scan.nextInt(); cy = scan.nextInt();
            if(jogo[cx][cy].equals(" ")){
                bag[i]= "Você disparou em" + cx+", "+cy+" e errou";
            }else{
                if(jogo[cx][cy].equals(SIMBOLO)){
                    pontuacaoNavio+=pn;
                    bag[i]= "Você disparou em" + cx+", "+cy+" e obteve "+pn+ " pontos";
                }
                if(jogo[cx][cy].equals(SIMBOLO2)){
                    pontuacaoCanhao+=pc;
                    bag[i]= "Você disparou em" + cx+", "+cy+" e obteve "+pc+ " pontos";
                }
                jogo[cx][cy]= "x";
                qtdNavio--;
                if(qtdNavio == 0){
                    System.out.println("Jogo finalizado");
                    System.out.println("Pontuação total: " + (pontuacaoCanhao+pontuacaoNavio));
                    for(int j = 0; j< bag.length; j++){
                        System.out.println(bag[j]);
                    }
                    
                    for(int k = 0; k<10 ; k++){
                        for( int l = 0; l<10; l++){
                            if(!jogo[k][l].equals("x")){
                                System.out.println(k+","+l+" "+ jogo[k][l]);
                            }
                        }
                    }
                }
            }
            
            if(i == disparo -1){
                    System.out.println("Jogo finalizado");
                    System.out.println("Pontuação total: " + (pontuacaoCanhao+pontuacaoNavio));
                    for(int j = 0; j< bag.length; j++){
                        System.out.println(bag[j]);
                    }
                    
                    
                    for(int k = 0; k<10 ; k++){
                        for( int l = 0; l<10; l++){
                            if(!jogo[k][l].equals("x")){
                                System.out.println(k+","+l+" "+ jogo[k][l]);
                            }
                        }
                    }
                }
        }
    }
}
