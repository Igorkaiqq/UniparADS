const http = require('http');
const { Client } = require('pg');

// Configurações do banco de dados
const client = new Client({
  user: 'postgres',
  host: 'localhost',
  database: 'unipar',
  password: 'Nesher#2019',
  port: 5432,
});

client.connect();

const server = http.createServer(async (req, res) => {
  if (req.url === '/' && req.method === 'GET') {
    try {
      const query = 'SELECT * FROM table_inv_switches x ORDER BY x.data desc LIMIT 100';
      const result = await client.query(query);

      const marcas = {};
      const modelos = {};
      const versoes = {};

      result.rows.forEach(row => {
        marcas[row.marca] = (marcas[row.marca] || 0) + 1;
        modelos[row.modelo] = (modelos[row.modelo] || 0) + 1;
        versoes[row.versao] = (versoes[row.versao] || 0) + 1;
      });

      res.writeHead(200, { 'Content-Type': 'text/html' });
      res.end(`
        <!DOCTYPE html>
        <html lang="pt-br">
        <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>Dashboard de Switches</title>
          <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
          <style>
            body {
              font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
              color: #f5f5f5;
              margin: 0;
              padding: 0;
              background-color: #1a1a1a;
            }
            h1 {
              text-align: center;
              color: #ffffff;
              padding: 20px 0;
              margin: 0;
              background-color: #6a1b9a;
              box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
            }
            .container {
              max-width: 1200px;
              margin: 20px auto;
              padding: 20px;
              background-color: #2c2c2c;
              border-radius: 8px;
              box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }
            .search-container {
              display: flex;
              flex-wrap: wrap;
              justify-content: center;
              gap: 10px;
              padding: 20px;
              background-color: #4a148c;
              border-radius: 8px;
              box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }
            .search-container label {
              font-size: 14px;
              color: #ddd;
            }
            .search-container input[type="text"] {
              padding: 8px;
              border: 1px solid #8e24aa;
              border-radius: 4px;
              width: 200px;
              box-sizing: border-box;
              background-color: #1f1f1f;
              color: #fff;
            }
            table {
              width: 100%;
              border-collapse: collapse;
              margin: 20px 0;
              background-color: #2e2e2e;
              border-radius: 8px;
              overflow: hidden;
              box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }
            th, td {
              border: 1px solid #444;
              padding: 10px;
              text-align: left;
              color: #f5f5f5;
              cursor: pointer;
            }
            th {
              background-color: #7b1fa2;
              position: relative;
            }
            th .sort-arrow {
              position: absolute;
              right: 8px;
              opacity: 0.6;
              transition: opacity 0.3s;
            }
            th:hover .sort-arrow {
              opacity: 1;
            }
            tr:nth-child(even) {
              background-color: #3c3c3c;
            }
            tr:hover {
              background-color: #512da8;
            }
            .charts-container {
              display: flex;
              flex-direction: column;
              align-items: center;
              margin-bottom: 20px;
            }
            .chart-wrapper {
              display: flex;
              flex-wrap: wrap;
              justify-content: space-around;
              width: 100%;
              margin-bottom: 40px;
            }
            .chart-container {
              display: flex;
              flex-direction: column;
              align-items: center;
              flex-basis: 48%;
            }
            canvas {
              width: 100%; 
              height: 120px;
              margin-bottom: 20px;
              background-color: #2e2e2e;
              border-radius: 8px;
              box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }
            @media (max-width: 768px) {
              .search-container {
                flex-direction: column;
                align-items: center;
              }
              .search-container label,
              .search-container input[type="text"] {
                width: 100%;
                text-align: center;
              }
              .chart-wrapper {
                flex-direction: column;
                align-items: center;
              }
            }
          </style>
        </head>
        <body>
          <h1>CONTROLE DE SWITCHES</h1>
          <div class="container">
            <div class="charts-container">
              <div class="chart-wrapper">
                <div class="chart-container">
                  <canvas id="chartMarcas"></canvas>
                  <canvas id="pieMarcas"></canvas>
                </div>
                <div class="chart-container">
                  <canvas id="chartModelos"></canvas>
                  <canvas id="pieModelos"></canvas>
                </div>
                <div class="chart-container">
                  <canvas id="chartVersoes"></canvas>
                  <canvas id="pieVersoes"></canvas>
                </div>
              </div>
            </div>
            
            <div class="search-container">
              <label>REGISTRO: <input type="text" id="search_registro" onkeyup="filterTable()"></label>
              <label>DATA: <input type="text" id="search_data" onkeyup="filterTable()"></label>
              <label>HORA: <input type="text" id="search_hora" onkeyup="filterTable()"></label>
              <label>HOSTNAME: <input type="text" id="search_hostname" onkeyup="filterTable()"></label>
              <label>IP ADDRESS: <input type="text" id="search_ip_address" onkeyup="filterTable()"></label>
              <label>MAC ADDRESS: <input type="text" id="search_mac_address" onkeyup="filterTable()"></label>
              <label>MARCA: <input type="text" id="search_marca" onkeyup="filterTable()"></label>
              <label>MODELO: <input type="text" id="search_modelo" onkeyup="filterTable()"></label>
              <label>NUM SERIE: <input type="text" id="search_num_serie" onkeyup="filterTable()"></label>
              <label>VERSÃO: <input type="text" id="search_versao" onkeyup="filterTable()"></label>
              <label>IMOBILIZADO: <input type="text" id="search_imobilizado" onkeyup="filterTable()"></label>
            </div>
            
            <table id="switchesTable">
              <thead>
                <tr>
                  <th onclick="sortTable(0)">REGISTRO <span class="sort-arrow">⬍</span></th>
                  <th onclick="sortTable(1)">DATA <span class="sort-arrow">⬍</span></th>
                  <th onclick="sortTable(2)">HORA <span class="sort-arrow">⬍</span></th>
                  <th onclick="sortTable(3)">HOSTNAME <span class="sort-arrow">⬍</span></th>
                  <th onclick="sortTable(4)">IP ADDRESS <span class="sort-arrow">⬍</span></th>
                  <th onclick="sortTable(5)">MAC ADDRESS <span class="sort-arrow">⬍</span></th>
                  <th onclick="sortTable(6)">MARCA <span class="sort-arrow">⬍</span></th>
                  <th onclick="sortTable(7)">MODELO <span class="sort-arrow">⬍</span></th>
                  <th onclick="sortTable(8)">NUM SERIE <span class="sort-arrow">⬍</span></th>
                  <th onclick="sortTable(9)">VERSÃO <span class="sort-arrow">⬍</span></th>
                  <th onclick="sortTable(10)">IMOBILIZADO <span class="sort-arrow">⬍</span></th>
                </tr>
              </thead>
              <tbody>
                ${result.rows.map(row => `
                  <tr>
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
                  </tr>
                `).join('')}
              </tbody>
            </table>
          </div>
          
          <script>
            function filterTable() {
              const filters = {
                registro: document.getElementById('search_registro').value.toLowerCase(),
                data: document.getElementById('search_data').value.toLowerCase(),
                hora: document.getElementById('search_hora').value.toLowerCase(),
                hostname: document.getElementById('search_hostname').value.toLowerCase(),
                ip_address: document.getElementById('search_ip_address').value.toLowerCase(),
                mac_address: document.getElementById('search_mac_address').value.toLowerCase(),
                marca: document.getElementById('search_marca').value.toLowerCase(),
                modelo: document.getElementById('search_modelo').value.toLowerCase(),
                num_serie: document.getElementById('search_num_serie').value.toLowerCase(),
                versao: document.getElementById('search_versao').value.toLowerCase(),
                imobilizado: document.getElementById('search_imobilizado').value.toLowerCase()
              };
              
              const rows = document.querySelectorAll('#switchesTable tbody tr');
              
              rows.forEach(row => {
                const cells = row.getElementsByTagName('td');
                const showRow = Object.keys(filters).every((key, index) => 
                  cells[index].textContent.toLowerCase().includes(filters[key])
                );
                row.style.display = showRow ? '' : 'none';
              });
            }
            
            function sortTable(columnIndex) {
              const table = document.getElementById('switchesTable');
              const rows = Array.from(table.rows).slice(1);
              const isAscending = table.getAttribute('data-sort-direction') === 'asc';
              
              rows.sort((a, b) => {
                const cellA = a.cells[columnIndex].textContent.trim().toLowerCase();
                const cellB = b.cells[columnIndex].textContent.trim().toLowerCase();
                return isAscending ? cellA.localeCompare(cellB) : cellB.localeCompare(cellA);
              });
              
              table.querySelector('tbody').append(...rows);
              table.setAttribute('data-sort-direction', isAscending ? 'desc' : 'asc');
            }
            
            // Gráficos de Barras
            const chartMarcas = new Chart(document.getElementById('chartMarcas').getContext('2d'), {
              type: 'bar',
              data: {
                labels: ${JSON.stringify(Object.keys(marcas))},
                datasets: [{
                  label: 'Marcas',
                  data: ${JSON.stringify(Object.values(marcas))},
                  backgroundColor: 'rgba(103, 58, 183, 0.7)',
                  borderColor: 'rgba(103, 58, 183, 1)',
                  borderWidth: 1
                }]
              },
              options: {
                scales: {
                  y: {
                    beginAtZero: true
                  }
                }
              }
            });
            
            const chartModelos = new Chart(document.getElementById('chartModelos').getContext('2d'), {
              type: 'bar',
              data: {
                labels: ${JSON.stringify(Object.keys(modelos))},
                datasets: [{
                  label: 'Modelos',
                  data: ${JSON.stringify(Object.values(modelos))},
                  backgroundColor: 'rgba(0, 150, 136, 0.7)',
                  borderColor: 'rgba(0, 150, 136, 1)',
                  borderWidth: 1
                }]
              },
              options: {
                scales: {
                  y: {
                    beginAtZero: true
                  }
                }
              }
            });
            
            const chartVersoes = new Chart(document.getElementById('chartVersoes').getContext('2d'), {
              type: 'bar',
              data: {
                labels: ${JSON.stringify(Object.keys(versoes))},
                datasets: [{
                  label: 'Versões',
                  data: ${JSON.stringify(Object.values(versoes))},
                  backgroundColor: 'rgba(255, 193, 7, 0.7)',
                  borderColor: 'rgba(255, 193, 7, 1)',
                  borderWidth: 1
                }]
              },
              options: {
                scales: {
                  y: {
                    beginAtZero: true
                  }
                }
              }
            });

            // Gráficos de Pizza
            const pieMarcas = new Chart(document.getElementById('pieMarcas').getContext('2d'), {
              type: 'pie',
              data: {
                labels: ${JSON.stringify(Object.keys(marcas))},
                datasets: [{
                  label: 'Marcas',
                  data: ${JSON.stringify(Object.values(marcas))},
                  backgroundColor: [
                    'rgba(103, 58, 183, 0.7)',
                    'rgba(0, 150, 136, 0.7)',
                    'rgba(255, 193, 7, 0.7)'
                  ],
                  borderColor: [
                    'rgba(103, 58, 183, 1)',
                    'rgba(0, 150, 136, 1)',
                    'rgba(255, 193, 7, 1)'
                  ],
                  borderWidth: 1
                }]
              }
            });

            const pieModelos = new Chart(document.getElementById('pieModelos').getContext('2d'), {
              type: 'pie',
              data: {
                labels: ${JSON.stringify(Object.keys(modelos))},
                datasets: [{
                  label: 'Modelos',
                  data: ${JSON.stringify(Object.values(modelos))},
                  backgroundColor: [
                    'rgba(103, 58, 183, 0.7)',
                    'rgba(0, 150, 136, 0.7)',
                    'rgba(255, 193, 7, 0.7)'
                  ],
                  borderColor: [
                    'rgba(103, 58, 183, 1)',
                    'rgba(0, 150, 136, 1)',
                    'rgba(255, 193, 7, 1)'
                  ],
                  borderWidth: 1
                }]
              }
            });

            const pieVersoes = new Chart(document.getElementById('pieVersoes').getContext('2d'), {
              type: 'pie',
              data: {
                labels: ${JSON.stringify(Object.keys(versoes))},
                datasets: [{
                  label: 'Versões',
                  data: ${JSON.stringify(Object.values(versoes))},
                  backgroundColor: [
                    'rgba(103, 58, 183, 0.7)',
                    'rgba(0, 150, 136, 0.7)',
                    'rgba(255, 193, 7, 0.7)'
                  ],
                  borderColor: [
                    'rgba(103, 58, 183, 1)',
                    'rgba(0, 150, 136, 1)',
                    'rgba(255, 193, 7, 1)'
                  ],
                  borderWidth: 1
                }]
              }
            });
          </script>
        </body>
        </html>
      `);
    } catch (err) {
      res.writeHead(500, { 'Content-Type': 'text/plain' });
      res.end('Erro ao buscar os dados.');
      console.error('Erro na consulta ao banco de dados:', err);
    }
  }
});

server.listen(3000, () => {
  console.log('Servidor rodando em http://localhost:3000');
});
