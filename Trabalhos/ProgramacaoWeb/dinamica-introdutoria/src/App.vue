<template>
  <div id="app">
    <header>
      <img src="https://jolluand.com.br/site/image/data/Uniforme%20Profissional/xLogo%20Empresas/Unipar.gif" alt="Logo">
      <h1>Bem vindo a minha página</h1>
    </header>
    <main>
      <section class="user-info">
        <h2 id="sobre">Sobre mim</h2>
        <p><strong>Nome: </strong> <span>{{ user.name }}</span></p>
        <p><strong>Idade: </strong> <span>{{ user.age }}</span></p>
        <p><strong>Sobre mim: </strong> <span>{{ user.aboutme }}</span></p>
      </section>
      <footer id="copy">
        <p>Copyright © 2024</p>
      </footer>
    </main>
  </div>
</template>

<script>
export default {
  data() {
    return {
      user: {}
    }
  },
  created() {
    this.fetchUserData();
  },
  methods: {
    async fetchUserData() {
      try {
        const apiUrl = 'https://a285-177-91-39-96.ngrok-free.app/api/user';
        const response = await fetch(apiUrl, {
          headers: {
            'ngrok-skip-browser-warning': 'true'
          }
        });
        if (!response.ok) {
          throw new Error('a resposta do servidor nao deu certo');
        }
        const data = await response.json();
        console.log(data);
        this.user = data;
      } catch (error) {
        console.error('Erro ao buscar dados da API:', error);
      }
    }
  }
}
</script>

<style scoped>
body {
  font-family: Arial, sans-serif;
  background-color: #ffffff;
  margin: 0;
  padding: 0;
}

#app {
  width: 80%;
  margin: 0 auto;
  background-color: #ffffff;
  padding: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

img {
  width: 200px;
  height: 200px;
}

header h1 {
  color: #e30225;
}

#sobre {
  color: #e30225;
}

#copy {
  color: #e30225;
}

header {
  display: flex;
  align-items: center;
  justify-content: center;
}

.user-info {
  margin-top: 20px;
}

.user-info p {
  font-size: 18px;
}

footer {
  text-align: center;
  margin-top: 20px;
}
</style>
