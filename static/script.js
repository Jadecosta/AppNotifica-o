function enviarLogin() {
    // Aqui você pode adicionar validações adicionais, se necessário
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    // Exemplo de validação simples (pode adicionar validação de credenciais reais)
    if (email && senha) {
        // Redireciona para tela_inicial.html
        window.location.href = "tela_inicial.html";
        return false; // Impede o envio real do formulário
    } else {
        alert("Por favor, preencha todos os campos.");
        return false; // Evita o envio do formulário se algum campo estiver vazio
    }
}

// Função para alternar o tipo de usuário
function toggleUserType(type) {
    const button = document.getElementById(`${type}Btn`);
    button.classList.toggle('active'); // Alterna entre ativo e inativo
}

// Função para enviar a notificação
function enviarNotificacao() {
    const curso = document.getElementById('curso').value;
    const sala = document.getElementById('sala').value;
    const mensagem = document.getElementById('mensagem').value;
    const alunoSelecionado = document.getElementById('alunoBtn').classList.contains('active');
    const professorSelecionado = document.getElementById('professorBtn').classList.contains('active');

    if (!alunoSelecionado && !professorSelecionado) {
        alert('Selecione pelo menos um tipo de destinatário: Aluno ou Professor.');
        return;
    }

    if (curso && sala && mensagem) {
        alert('Notificação enviada com sucesso!');
        // Aqui você pode adicionar o código para realmente enviar a notificação
    } else {
        alert('Por favor, preencha todos os campos.');
    }
}

// Função para exibir a saudação de acordo com a hora do dia
function saudacao() {
    const greetingElement = document.getElementById('greeting');
    const horaAtual = new Date().getHours();
    let saudacao = " ";

    if (horaAtual >= 5 && horaAtual < 12) {
        saudacao += "Bom dia!";
    } else if (horaAtual >= 12 && horaAtual < 18) {
        saudacao += "Boa tarde!";
    } else {
        saudacao += "Boa noite!";
    }

    greetingElement.textContent = saudacao;
}
// Executa a saudação quando a página é carregada
window.onload = saudacao;

// Nome do usuário
const userName = "João"; // Substitua pelo nome real ou use uma variável dinâmica

// Substitui o texto do elemento com id "user-name" pelo nome do usuário
document.getElementById("user-name").textContent = userName;

