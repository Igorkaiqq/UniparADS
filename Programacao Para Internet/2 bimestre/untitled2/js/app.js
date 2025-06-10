const inpLadoX = document.getElementById('ladoX');
const inpLadoY = document.getElementById('ladoY');
const inpLadoZ = document.getElementById('ladoZ');
const btVerificarTriangulo = document.getElementById('verificarTriangulo');
const resultadoTriangulo = document.getElementById('resultadoTriangulo');

btVerificarTriangulo.addEventListener('click', e => {

  ladoX = parseFloat(inpLadoX.value);
  ladoY = parseFloat(inpLadoY.value);
  ladoZ = parseFloat(inpLadoZ.value);

  const triangulo = ladoX < ladoY + ladoZ && ladoY <  ladoZ + ladoX && ladoZ <  ladoY + ladoX;

  if (triangulo) {
    if (ladoX === ladoY && ladoY === ladoZ) {
      resultadoTriangulo.textContent = 'Equiláteros: tem os comprimentos dos três lados iguais';
    } else if (ladoX === ladoY || ladoX === ladoZ || ladoY === ladoZ) {
      resultadoTriangulo.textContent = 'Isósceles: tem os comprimentos de dois lados iguais';
    } else {
      resultadoTriangulo.textContent = 'Escaleno: tem os comprimentos de três lados diferentes.';
    }
  } else {
    resultadoTriangulo.textContent = 'Não forma triangulo esses valores';
  }
})

const inpAltura = document.getElementById('altura');
const inpPeso = document.getElementById('peso');
const btVerificarImc = document.getElementById('verificarIMC');
const resultadoIMC = document.getElementById('resultadoIMC');
const indicesIMC = document.getElementById('indicesIMC');

btVerificarImc.addEventListener('click', e => {

  const altura = parseFloat(inpAltura.value);
  const peso = parseFloat(inpPeso.value);

  const imc = peso / (altura * altura);

  resultadoIMC.textContent = 'Seu IMC é :'+imc;
  indicesIMC.innerHTML = '○ Abaixo de 18.5 → Abaixo do peso<br>' +
    '○ 18.5 a 24.9 → Peso normal<br>' +
    '○ 25 a 29.9 → Sobrepeso<br>' +
    '○ 30 a 34.9 → Obesidade grau 1<br>' +
    '○ 35 a 39.9 → Obesidade grau 2<br>' +
    '○ 40+ → Obesidade grau 3.';

})

const inpValorCarro = document.getElementById('valorCarro');
const inpAnoCarro = document.getElementById('anoCarro');
const btVerificarImposto = document.getElementById('verificarImposto');
const resultadoImposto = document.getElementById('resultadoImposto');

btVerificarImposto.addEventListener('click', e => {
  const valorCarro = parseFloat(inpValorCarro.value);
  const anoCarro = parseFloat(inpAnoCarro.value);
  let imposto;

  if (anoCarro < 1990) {
     imposto = valorCarro * 0.01;
  } else {
     imposto = valorCarro * 0.015;
  }

  resultadoImposto.textContent = 'O valor do imposto é de R$'+imposto;

})

const inpSalario = document.getElementById('salario');
const inpCargo = document.getElementById('cargo');
const btVerificarSalario = document.getElementById('verificarSalario');
const resultadoSalario = document.getElementById('resultadoSalario');

btVerificarSalario.addEventListener('click', e => {
  const salario = parseFloat(inpSalario.value);
  const cargo = inpCargo.value.trim().toLowerCase();

  let novoSalario;

  if (cargo === 'gerente') {
    novoSalario = salario * 1.10;
  } else if (cargo === 'engenheiro') {
    novoSalario = salario * 1.20;
  } else if (cargo === 'técnico') {
    novoSalario = salario * 1.30;
  } else {
    novoSalario = salario * 1.40;
  }

  resultadoSalario.innerHTML = 'Salário Antigo: R$'+salario.toFixed(2)+'.<br>' +
    'Salário Novo: R$'+novoSalario.toFixed(2)+'.<br>' +
    'Diferença de salário: R$'+(novoSalario - salario).toFixed(2)+'.<br>'

})

const inpSaldo = document.getElementById('saldoCredito');
const resultadoCredito = document.getElementById('resultadoCredito');
const btVerificarCredito = document.getElementById('verificarCreditoBancario');

btVerificarCredito.addEventListener('click', e => {
  const saldo = parseFloat(inpSaldo.value);

  if (saldo <= 200) {
    resultadoCredito.textContent = 'Com esse saldo você não consegue nenhum crédito'
  } else if (saldo > 200 && saldo <= 400) {
    resultadoCredito.innerHTML = 'Com esse saldo você consegue um crédito de R$'+saldo*0.2+'.<br>'
    + 'Totalizando R$'+saldo*1.2+'.';
  } else if (saldo > 400 && saldo <= 600) {
    resultadoCredito.innerHTML = 'Com esse saldo você consegue um crédito de R$'+saldo*0.3+'.<br>'
      + 'Totalizando R$'+saldo*1.3+'.';
  } else {
    resultadoCredito.innerHTML = 'Com esse saldo você consegue um crédito de R$'+saldo*0.4+'.<br>'
      + 'Totalizando R$'+saldo*1.4+'.';
  }

})

const inpProduto = document.getElementById('produto');
const inpQuantidade = document.getElementById('quantidade');
const btCalcularLanchonete = document.getElementById('calcularLanchonete');
const resultadoLanchonete = document.getElementById('resultadoLanchonete');

btCalcularLanchonete.addEventListener('click', e => {
  const quantidade = parseFloat(inpQuantidade.value);
  const produto = inpProduto.value.trim().toLowerCase();

  if (produto === 'cachorro quente') {
    resultadoLanchonete.textContent = 'A compra ficou em R$'+quantidade*11;
  } else if (produto === 'bauru') {
    resultadoLanchonete.textContent = 'A compra ficou em R$'+quantidade*8.5;
  } else if (produto === 'misto quente') {
    resultadoLanchonete.textContent = 'A compra ficou em R$'+quantidade*8;
  } else if (produto === 'hamburguer') {
    resultadoLanchonete.textContent = 'A compra ficou em R$'+quantidade*9;
  } else if (produto === 'cheeseburger') {
    resultadoLanchonete.textContent = 'A compra ficou em R$'+quantidade*10;
  } else if (produto === 'cachorro quente') {
    resultadoLanchonete.textContent = 'A compra ficou em R$'+quantidade*4.5;
  } else {
    resultadoLanchonete.textContent = 'Opção inválida';
  }

})

const inpValorProduto = document.getElementById('valorProduto');
const selCodigoPagamento = document.getElementById('codigoPagamento');
const btVerificarVenda = document.getElementById('verificarVenda');
const resultadoVenda = document.getElementById('resultadoVenda');

btVerificarVenda.addEventListener('click', e => {
  const valorProduto = parseFloat(inpValorProduto.value);
  const codigoPagamento = selCodigoPagamento.value;

  if (codigoPagamento === '1') {
    resultadoVenda.textContent = 'Valor total da compra R$'+valorProduto*0.9;
  } else if (codigoPagamento === '2') {
    resultadoVenda.textContent = 'Valor total da compra R$'+valorProduto*0.85;
  } else if (codigoPagamento === '3') {
    resultadoVenda.textContent = 'Valor total da compra R$'+valorProduto+' dividido em 2 vezes';
  } else if (codigoPagamento === '4') {
    resultadoVenda.textContent = 'Valor total da compra R$'+valorProduto*1.1+' dividido em 2 vezes';
  } else {
    resultadoVenda.textContent = 'Forma de Pagamento inválida'
  }
})

const selNivel = document.getElementById('nivel');
const inpHorasAula = document.getElementById('horasAula');
const btCalcularHorasAula = document.getElementById('calcularHoras');
const salarioProfessor  = document.getElementById('salarioProfessor');

btCalcularHorasAula.addEventListener('click', e => {

  const nivel = selNivel.value;
  const horasAula = parseFloat(inpHorasAula.value);

  let salario;

  if (nivel === '1') {
    salario = 12 * horasAula * 4.5;
    salarioProfessor.textContent = 'Salário total R$'+salario;
  } else if (nivel === '2') {
    salario = 17 * horasAula * 4.5;
    salarioProfessor.textContent = 'Salário total R$'+salario;
  } else if (nivel === '3') {
    salario = 25 * horasAula * 4.5;
    salarioProfessor.textContent = 'Salário total R$'+salario;
  } else {
    salarioProfessor.textContent = 'Nível inválido';
  }
})
