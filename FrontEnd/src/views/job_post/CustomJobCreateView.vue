<template>
  <form @submit.prevent="createMyJob">
    <div>
      <input type="text" v-model="newMyRecruit.title" placeholder="공고명" required />
      <input type="text" v-model="newMyRecruit.companyName" placeholder="회사명" required />
      <input type="text" v-model="newMyRecruit.job" placeholder="직무명" required />
      <input type="datetime-local" v-model="newMyRecruit.openingDate" />
      <input type="datetime-local" v-model="newMyRecruit.expirationDate" />
      <input type="text" v-model="newMyRecruit.description" placeholder="기타 설명" />
    </div>
    <div>
      <button>등록하기</button>
    </div>
  </form>
</template>

<script setup>
import { ref } from "vue";
import { useMyRecruitStore } from "@/stores/myRecruit";
import { useRouter } from "vue-router";
const router = useRouter();

const myRecruitStore = useMyRecruitStore();

const newMyRecruit = ref({
  userId: "",
  companyName: "",
  job: "",
  openingDate: "",
  expirationDate: "",
  description: "",
  title: "",
});

const createMyJob = async () => {
  await myRecruitStore.createMyRecruit(newMyRecruit);
  newMyRecruit.value = {
    userId: "",
    companyName: "test company",
    job: "test job",
    openingDate: "",
    expirationDate: "",
    description: "test description",
  };
  console.log();
  router.push({ name: "BlogReview" });
};
</script>

<style scoped>
div {
  display: flex;
  flex-direction: column;
  margin: 20px;
}

input[type="text"],
input[type="datetime-local"] {
  padding: 8px;
  margin: 5px 0;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

button {
  padding: 10px 20px;
  margin: 10px 0;
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}
</style>
