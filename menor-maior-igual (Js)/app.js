/**
 * @author Matsukii
 * @version js.0.3.1
 * @description Algoritimo para verificar se um numero informado e menor, igual ou maior ao pre definido
 * @see Java-version tambem disponivel em Java (me parece um pouco pior que essa...)
 */
let num = 0;

// controlam o loop
let acertou = false;
let tentativas = 0;
let maxT = 10;
let printValue = false;

/**
 * @description definir numero para o teste 
 * @param {Number}  n definir este numero (gera aleatorio se nao for informado)
 */
let setPass = (n) => {
    if(n == 0){
        num = Math.floor(Math.random()*10);
    }
    else{ num = n }
    // console.log(num);
}

let start = (n = 0) => {
    setPass(n);
    console.log(num);
    acertou = false;
    tentativas = 0;
    while(!acertou){
        if(tentativas == maxT){
            alert(`Numero maximo de tentativas \n ${tentativas}/${maxT}`);
            break;
        }
        let toTest = prompt("Informe um numero \n(envie 'stop' para parar)");
        if(toTest == 'stop'){
            break;
        }
        else if(toTest == 'setnum'){
            setPass(prompt("Novo valor correto"));
        }
        else if(toTest == 'show'){
            showResult(num);
        }
        else if(toTest == ''){
            break;
        }
        else{
            if(!isNaN(toTest)){
                test(toTest);
            }
        }
    }
}

/**
 * @description      testa o valor se é menor, maior ou igual ao informado
 * @param {Number} n numero a ser testado 
 */
let test = (n) => {
    if(n > num){
        if(n-5 < num){
            alert('O numero é maior mas esta perto')
        }
        else{
            alert('O numero informado é maior que o correto')
        }
        tentativas++;
    }
    else if(n < num){
        if(n+5 > num){
            alert('O numero é menor mas esta perto')
        }
        else{
            alert('O numero informado é menor que o correto')
        }
        tentativas++;
    }
    else if(n == num){
        alert("Acertou! \nnum = " + n + "\nem " + tentativas + " tentativas");
        acertou = true;
        tentativas = 10;
    }
}

const showResult = (v) => {
    let p = `Num = ${v}`;
    alert(p);
    console.log(p);
}
