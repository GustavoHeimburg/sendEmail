
    document.getElementById('emailForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Impede o envio do formulário padrão
    var email = document.getElementById('email').value;
    sendEmail(email);
});

    function sendEmail(email) {
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/sendEmail', true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE) {
    if (xhr.status === 200) {
    alert(xhr.responseText); // Exibe a resposta do servidor
} else {
    alert('Erro ao enviar o e-mail');
}
}
};
    xhr.send('email=' + encodeURIComponent(email));
}
