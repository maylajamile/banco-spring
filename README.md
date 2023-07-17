## Backend Aplicação Banco

Esta API é responsável por fornecer os dados de transferência de acordo com o número de uma conta bancária, é possível fazer uma busca mais completa por meio dos parâmetros <em>dataInicio</em> e <em>dataFinal</em> para determinar um período e por <em>operador </em>para buscar pelo nome do operador da transferência. 

<table>
<caption><strong>Url:</strong></caption>
  <thead>
    <tr>
      <th>Endpoint</th>
      <th>Descrição</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>http://localhost:8080/transferencias/{idConta}</td>
      <td>Listar todas as transferências de uma conta</td>
    </tr>
  </tbody>
</table>

<h4>Exemplo de url com passagem de parâmetros:</h4>

localhost:8080/transferencias/1?operador=Beltrano&dataInicio=2019-01-01&dataFinal=2019-10-10

