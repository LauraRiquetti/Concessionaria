import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Seja bem-vindo à concessionária! ---");

        String resposta;
        Scanner in = new Scanner(System.in);

        // Chama o menu enquanto o usuário quiser continuar
        do {
            Funcionarios.iniciar(in);

            System.out.println("Deseja voltar para o menu novamente?");
            System.out.println("Digite 'sim' para voltar ou 'não' para sair:");
            resposta = in.nextLine().toLowerCase();
        } while (resposta.equals("sim"));

        System.out.println("Encerrando o sistema...");
        in.close();
    }

    public static class Funcionarios {
        // Mantemos os arrays e contador estáticos para persistirem entre chamadas
        private static final int USUARIOS_MAX = 50;
        private static String[] usuarios = new String[USUARIOS_MAX];
        private static int[] senhasUsuarios = new int[USUARIOS_MAX];
        private static int contador = 0;

        public static void iniciar(Scanner in) {
            System.out.println("\nFaça login no sistema para entrar:");
            System.out.println("1. Fazer Login");
            System.out.println("2. Iniciar Cadastro");
            System.out.print("Escolha uma opção: ");

            int entrada = in.nextInt();
            in.nextLine(); // limpar o buffer

            switch (entrada) {
                case 1:
                    login(in);
                    break;
                case 2:
                    cadastrar(in);
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida.");
            }
        }

        public static void login(Scanner in)
        {
            if (contador == 0) {
                System.out.println("Nenhum usuário cadastrado ainda. Faça um cadastro primeiro!");
                return;
            }

            System.out.print("Insira o nome de usuário já cadastrado: ");
            String nomeDeAcesso = in.nextLine();

            int indice = -1;
            for (int i = 0; i < contador; i++) {
                if (usuarios[i].equalsIgnoreCase(nomeDeAcesso)) {
                    indice = i;
                    break;
                }
            }

            if (indice == -1) {
                System.out.println("Erro! Usuário não cadastrado!");
                return;
            }

            System.out.print("Insira a senha da conta: ");
            int senha = in.nextInt();
            in.nextLine(); // limpar buffer

            if (senhasUsuarios[indice] == senha) {
                System.out.println("Login feito com sucesso!");
                System.out.println("Bem-vindo(a), " + usuarios[indice] + "!");
                Atividades.menu(in);

            } else {
                System.out.println("Erro. Senha incorreta!");
            }
        }

        public static void cadastrar(Scanner in) {
            if (contador >= USUARIOS_MAX) {
                System.out.println("Limite máximo de usuários atingido!");
                return;
            }

            System.out.print("Insira o nome de usuário a ser cadastrado: ");
            String nomeDeAcesso = in.nextLine();

            for (int i = 0; i < contador; i++) {
                if (nomeDeAcesso.equalsIgnoreCase(usuarios[i])) {
                    System.out.println("Erro. Usuário já cadastrado!");
                    return;
                }
            }

            usuarios[contador] = nomeDeAcesso;

            System.out.print("Insira a senha de sua conta: ");
            senhasUsuarios[contador] = in.nextInt();
            in.nextLine(); // limpar buffer

            contador++;
            System.out.println("Usuário cadastrado com sucesso!");
        }
    }
    public static class Veiculos {
        public static void tiposVeiculos(Scanner in) {
            System.out.println("Escolha um tipo de veículo abaixo:");
            System.out.println("1. Motocicletas");
            System.out.println("2. Carros");
            System.out.println("3. Caminhões");
            System.out.print("Escolha uma opção: ");

            int entrada = in.nextInt();
            in.nextLine(); // limpar o buffer
            switch (entrada) {
                case 1:
                    motocicletas(in);
                    break;
                case 2:
                    carros(in);
                    break;
                case 3:
                    caminhoes(in);
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida!");
                    break;
            }
        }
        public static void motocicletas(Scanner in)
        {
            System.out.println("Escolha um modelo de motocicleta abaixo:");
            System.out.println("1. Honda CB 500F");
            System.out.println("2. Yamaha MT-07");
            System.out.println("3. BMW R 1250 GS");
            System.out.println("4. Kawasaki Ninja 400");
            System.out.println("5. Kawasaki Ninja 400");
            System.out.print("Escolha uma opção: ");

            int entrada = in.nextInt();
            in.nextLine(); // limpar o buffer
            switch (entrada) {
                case 1:
                    System.out.println("Honda CB 500F");
                    System.out.println("Ano de fabricação: 2024");
                    System.out.println("Preço: R$ 39.100,00");
                    System.out.println("Uma naked de média cilindrada, versátil e ideal para uso urbano e viagens curtas. " +
                            "Possui motor bicilíndrico de 471 cc e design moderno e esportivo.");
                    System.out.println("Modelo usado - 12.000 Kms rodados");
                    System.out.println("Status: disponível");
                    break;
                case 2:
                    System.out.println("Yamaha MT-07");
                    System.out.println("Ano de fabricação: 2024");
                    System.out.println("Preço: R$ 57.990,00");
                    System.out.println("Uma hyper naked de 689 cc, conhecida pelo seu alto torque e agilidade. " +
                            "O motor CP2 (Crossplane) proporciona uma pilotagem emocionante, sendo leve e potente.");
                    System.out.println("Modelo novo");
                    System.out.println("Status: disponível");
                    break;
                case 3:
                    System.out.println("BMW R 1250 GS");
                    System.out.println("Ano de fabricação: 2024");
                    System.out.println("Preço: R$ 123.500,00");
                    System.out.println("Uma lendária motocicleta adventure/big trail de alta cilindrada (1.254 cc). " +
                            "Excelente para longas viagens e terrenos variados, equipada com motor Boxer e muita tecnologia.");
                    System.out.println("Modelo novo");
                    System.out.println("Status: disponível");
                    break;
                case 4:
                    System.out.println("Kawasaki Ninja 400");
                    System.out.println("Ano de fabricação: 2024");
                    System.out.println("Preço: R$ 36.500,00");
                    System.out.println("Uma esportiva de entrada com 399 cc. Oferece desempenho empolgante, agilidade e um visual " +
                            "agressivo inspirado nas motos de corrida da marca, ideal para quem busca uma esportividade acessível.");
                    System.out.println("Modelo usado - 20.000 KMs rodados");
                    System.out.println("Status: disponível");
                    break;
                case 5:
                    System.out.println("Harley-Davidson Iron 883");
                    System.out.println("Ano de fabricação: 2020/2021");
                    System.out.println("Preço: R$ 60.000,00");
                    System.out.println("Uma lendária motocicleta adventure/big trail de alta cilindrada (1.254 cc). " +
                            "Excelente para longas viagens e terrenos variados, equipada com motor Boxer e muita tecnologia.Uma cruiser da linha Sportster, com estilo \"Dark Custom\"," +
                            " motor Evolution® V-Twin de 883 cc e visual totalmente preto e despojado. É um ícone da cultura custom.");
                    System.out.println("Modelo novo");
                    System.out.println("Status: disponível");
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida!");
                    break;
            }
        }
        public static void carros(Scanner in)
        {
            System.out.println("Escolha um modelo de carro abaixo:");
            System.out.println("1. Chevrolet Onix");
            System.out.println("2. Volkswagen T-Cross");
            System.out.println("3. Fiat Strada");
            System.out.println("4. Audi A3 Sedan");
            System.out.println("5. Land Rover Discovery Sport");
            System.out.print("Escolha uma opção: ");

            int entrada = in.nextInt();
            in.nextLine(); // limpar o buffer
            switch (entrada) {
                case 1:
                    System.out.println("Chevrolet Onix");
                    System.out.println("Ano de fabricação: 2024");
                    System.out.println("Preço: R$ 86.150,00");
                    System.out.println("Hatch compacto líder de vendas, conhecido por seu conjunto moderno, motores 1.0 aspirado e turbo, " +
                            "e bom pacote de segurança (6 airbags de série em muitas versões). Versátil para o dia a dia.");
                    System.out.println("Modelo usado - 15.000 Kms rodados");
                    System.out.println("Status: disponível");
                    break;
                case 2:
                    System.out.println("Volkswagen T-Cross");
                    System.out.println("Ano de fabricação: 2024");
                    System.out.println("Preço: R$ 119.890,00");
                    System.out.println("SUV compacto de sucesso. Destaca-se pelo seu motor TSI turbo, bom espaço interno e acabamento, " +
                            "além de ser construído sobre a plataforma moderna MQB. Ideal para famílias e uso urbano/viagens.");
                    System.out.println("Modelo novo");
                    System.out.println("Status: disponível");
                    break;
                case 3:
                    System.out.println("Fiat Strada");
                    System.out.println("Ano de fabricação: 2024");
                    System.out.println("Preço: R$ 103.990,00");
                    System.out.println("Picape compacta líder de vendas no Brasil. Oferece versões Cabine Simples e Cabine Dupla, " +
                            "motor Firefly 1.3 ou o novo 1.0 Turbo, e é ideal tanto para o trabalho quanto para o uso diário.");
                    System.out.println("Modelo novo");
                    System.out.println("Status: disponível");
                    break;
                case 4:
                    System.out.println("Audi A3 Sedan");
                    System.out.println("Ano de fabricação: 2024");
                    System.out.println("Preço: R$ 285.990,00");
                    System.out.println("Sedã premium. Oferece alto nível de tecnologia e acabamento, com motor 2.0 TFSI (mild-hybrid em " +
                            "algumas versões) e câmbio S tronic. Representa o segmento de luxo de entrada com desempenho esportivo.");
                    System.out.println("Modelo novo");
                    System.out.println("Status: disponível");
                    break;
                case 5:
                    System.out.println("Land Rover Discovery Sport");
                    System.out.println("Ano de fabricação: 2024");
                    System.out.println("Preço: R$ 349.900,00");
                    System.out.println("SUV de luxo com capacidade 5 ou 5+2 lugares. Combina refinamento, tração 4x4 e motores potentes, " +
                            "incluindo opções híbridas leves (MHEV). É focado em versatilidade, conforto e capacidade off-road moderada.");
                    System.out.println("Modelo novo");
                    System.out.println("Status: disponível");
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida!");
                    break;
            }
        }
        public static void caminhoes(Scanner in)
        {
            System.out.println("Escolha um modelo de caminhão abaixo:");
            System.out.println("1. Volvo FH 540 6x4");
            System.out.println("2. Scania R 450 6x2");
            System.out.println("3. Mercedes-Benz Actros 2651 6x4");
            System.out.print("Escolha uma opção: ");

            int entrada = in.nextInt();
            in.nextLine(); // limpar o buffer
            switch (entrada)
            {
                case 1:
                    System.out.println("Volvo FH 540 6x4");
                    System.out.println("Ano de fabricação: 2024");
                    System.out.println("Preço: R$ 810.000,00");
                    System.out.println("Líder de vendas e sinônimo de robustez para grandes cargas e longas distâncias, " +
                            "com destaque para a transmissão I-Shift.");
                    System.out.println("Modelo usado - 45.000 Kms rodados");
                    System.out.println("Status: disponível");
                    break;
                case 2:
                    System.out.println("Scania R 450 6x2");
                    System.out.println("Ano de fabricação: 2024");
                    System.out.println("Preço: R$ 119.890,00");
                    System.out.println("Focado em eficiência e baixo consumo de combustível, é a escolha ideal para " +
                            "um excelente equilíbrio entre desempenho (450 cv) e economia em rotas rodoviárias.");
                    System.out.println("Modelo novo");
                    System.out.println("Status: disponível");
                    break;
                case 3:
                    System.out.println("Mercedes-Benz Actros 2651 6x4");
                    System.out.println("Ano de fabricação: 2024");
                    System.out.println("Preço: R$ 103.990,00");
                    System.out.println("Caminhão tecnológico e seguro, ideal para composições pesadas, com foco em " +
                            "conforto, robustez e avançados sistemas de assistência ao motorista.");
                    System.out.println("Modelo novo");
                    System.out.println("Status: disponível");
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida!");
                    break;
            }
        }

    }
    public static class Clientes {
        public static void clientes(Scanner in) {
            System.out.println("Escolha um cliente abaixo:");
            System.out.println("1. Romário de Souza Lima");
            System.out.println("2. Joana de Castro");
            System.out.println("3. Fernanda Silva");
            System.out.println("4. Daniel Nascimento");
            System.out.println("Escolha uma opção: ");

            int entrada = in.nextInt();
            in.nextLine(); // limpar o buffer
            switch (entrada) {
                case 1:
                    System.out.println("Romário de Souza Lima");
                    System.out.println("Data de Nascimento: 30/12/1976");
                    System.out.println("Profissão: Joalheiro");
                    break;
                case 2:
                    System.out.println("Joana de Castro");
                    System.out.println("Data de Nascimento: 13/05/1997");
                    System.out.println("Profissão: Costureira");
                    break;
                case 3:
                    System.out.println("Fernanda Silva");
                    System.out.println("Data de Nascimento: 21/09/1983");
                    System.out.println("Profissão: Enfermeira");
                    break;
                case 4:
                    System.out.println("Daniel Nascimento");
                    System.out.println("Data de Nascimento: 12/10/2000");
                    System.out.println("Profissão: Jornalista");
                default:
                    System.out.println("Por favor, digite uma opção válida!");
                    break;
            }
        }
    }
    public static class Vendedores
    {
        public static void vendedores(Scanner in)
        {
            System.out.println("Escolha um vendedor abaixo:");
            System.out.println("1. Romário de Souza Lima");
            System.out.println("2. Joana de Castro");
            System.out.println("3. Fernanda Silva");
            System.out.println("4. Daniel Nascimento");
            System.out.println("Escolha uma opção: ");

            int entrada = in.nextInt();
            in.nextLine(); // limpar o buffer
            switch (entrada) {
                case 1:
                    System.out.println("Romário de Souza Lima");
                    System.out.println("Data de Nascimento: 30/12/1976");
                    System.out.println("Profissão: Joalheiro");
                    break;
                case 2:
                    System.out.println("Joana de Castro");
                    System.out.println("Data de Nascimento: 13/05/1997");
                    System.out.println("Profissão: Costureira");
                    break;
                case 3:
                    System.out.println("Fernanda Silva");
                    System.out.println("Data de Nascimento: 21/09/1983");
                    System.out.println("Profissão: Enfermeira");
                    break;
                case 4:
                    System.out.println("Daniel Nascimento");
                    System.out.println("Data de Nascimento: 12/10/2000");
                    System.out.println("Profissão: Jornalista");
                default:
                    System.out.println("Por favor, digite uma opção válida!");
                    break;
            }
        }
    }
    public static class Atividades
    {
        public static void menu(Scanner in) {
            System.out.println("Escolha uma das atividades do menu abaixo:");
            System.out.println("1. Vender");
            System.out.println("2. Reservar");
            System.out.println("3. Comprar");
            System.out.print("Escolha uma opção: ");

            int entrada = in.nextInt();
            in.nextLine(); // limpar o buffer
            switch (entrada) {
                case 1:
                    Atividades.vender(in);
                    break;
                case 2:
                    Atividades.reservar(in);
                    break;
                case 3:
                    Atividades.comprar(in);
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida.");
                    break;
            }
        }
        public static void vender(Scanner in)
        {
            System.out.println("O que deseja escolher primeiro?");
            System.out.println("1. Veículos disponíveis");
            System.out.println("2. Clientes");
            System.out.println("3. Vendedores");
            System.out.print("Escolha uma opção: ");

            int entrada = in.nextInt();
            in.nextLine(); // limpar o buffer
            switch (entrada) {
                case 1:
                    Veiculos.tiposVeiculos(in);
                    break;
                case 2:
                    Clientes.clientes(in);
                    break;
                case 3:
                    Vendedores.vendedores(in);
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida.");
                    break;
            }
        }
        public static void comprar(Scanner in)
        {
            System.out.println("O que deseja escolher primeiro?");
            System.out.println("1. Veículos disponíveis");
            System.out.println("2. Clientes");
            System.out.println("3. Vendedores");
            System.out.print("Escolha uma opção: ");

            int entrada = in.nextInt();
            in.nextLine(); // limpar o buffer
            switch (entrada) {
                case 1:
                    Veiculos.tiposVeiculos(in);
                    break;
                case 2:
                    Clientes.clientes(in);
                    break;
                case 3:
                    Vendedores.vendedores(in);
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida.");
                    break;
            }
        }
        public static void reservar(Scanner in)
        {
            System.out.println("O que deseja escolher primeiro?");
            System.out.println("1. Veículos disponíveis");
            System.out.println("2. Clientes");
            System.out.println("3. Vendedores");
            System.out.print("Escolha uma opção: ");

            int entrada = in.nextInt();
            in.nextLine(); // limpar o buffer
            switch (entrada) {
                case 1:
                    Veiculos.tiposVeiculos(in);
                    break;
                case 2:
                    Clientes.clientes(in);
                    break;
                case 3:
                    Vendedores.vendedores(in);
                    break;
                default:
                    System.out.println("Por favor, digite uma opção válida.");
                    break;
            }
        }
    }

}
