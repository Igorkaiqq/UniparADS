const express = require('express');
const { Pool } = require('pg');

const app = express();
const port = 3000;

// Configuração da conexão com o banco de dados PostgreSQL
const pool = new Pool({
    user: 'postgres',  // Substitua pelo seu usuário do PostgreSQL
    host: 'localhost',
    database: 'unipar',  // Substitua pelo nome do seu banco de dados
    password: 'Nesher#2019',  // Substitua pela sua senha do PostgreSQL
    port: 5432,
});

// Rota para exibir a tabela com paginação
app.get('/', async (req, res) => {
    try {
        // Definir número de resultados por página e a página atual (valores padrão)
        const resultsPerPage = 20;
        const page = parseInt(req.query.page) || 1;

        // Calcular o offset com base na página atual
        const offset = (page - 1) * resultsPerPage;

        // Consulta SQL com LIMIT e OFFSET para paginação
        const result = await pool.query('SELECT * FROM table_inv_switches LIMIT $1 OFFSET $2', [resultsPerPage, offset]);

        let tableRows = '';
        result.rows.forEach(row => {
            tableRows += `<tr>
                      <td>${row.registro}</td>
                      <td>${row.data}</td>
                      <td>${row.hora}</td>
                      <td>${row.hostname}</td>
                      <td>${row.ip_address}</td>
                      <td>${row.mac_address}</td>
                      <td>${row.marca}</td>
                      <td>${row.modelo}</td>
                      <td>${row.num_serie}</td>
                      <td>${row.versao}</td>
                      <td>${row.imobilizado}</td>
                    </tr>`;
        });

        const html = `
      <!DOCTYPE html>
      <html lang="pt-BR">
      <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>Dashboard de Switches</title>
          <style>
              body {
                  font-family: Arial, sans-serif;
                  margin: 20px;
              }
              table {
                  width: 100%;
                  border-collapse: collapse;
                  margin-bottom: 20px;
              }
              table, th, td {
                  border: 1px solid #ddd;
              }
              th, td {
                  padding: 8px;
                  text-align: left;
              }
              th {
                  background-color: #f2f2f2;
              }
              .pagination {
                  display: flex;
                  justify-content: center;
                  margin-top: 20px;
              }
              .pagination a {
                  margin: 0 5px;
                  padding: 8px 16px;
                  text-decoration: none;
                  border: 1px solid #ddd;
                  color: #000;
              }
              .pagination a.active {
                  background-color: #007bff;
                  color: white;
                  border: 1px solid #007bff;
              }
          </style>
      </head>
      <body>

          <h2>Dashboard de Switches</h2>
          <table>
              <thead>
                  <tr>
                      <th>REGISTRO</th>
                      <th>DATA</th>
                      <th>HORA</th>
                      <th>HOSTNAME</th>
                      <th>IP_ADDRESS</th>
                      <th>MAC_ADDRESS</th>
                      <th>MARCA</th>
                      <th>MODELO</th>
                      <th>NUM_SERIE</th>
                      <th>VERSAO</th>
                      <th>IMOBILIZADO</th>
                  </tr>
              </thead>
              <tbody>
                  ${tableRows}
              </tbody>
          </table>
          <div class="pagination">
              <a href="/?page=${page - 1}" ${page <= 1 ? 'style="display: none;"' : ''}>&laquo; Anterior</a>
              <a href="/?page=${page}" class="active">${page}</a>
              <a href="/?page=${page + 1}">Próxima &raquo;</a>
          </div>

      </body>
      </html>
    `;

        res.send(html);
    } catch (err) {
        console.error(err);
        res.status(500).send('Erro ao buscar dados');
    }
});

// Iniciar o servidor
app.listen(port, () => {
    console.log(`Servidor rodando em http://localhost:${port}`);
});
