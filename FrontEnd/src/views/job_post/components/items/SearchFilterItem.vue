<template>
  <div class="category-container">
    <div class="category-header">
      <h2>{{ category.jobName }}</h2>
      <div class="search-bar">
        <i
          class="fa-solid fa-magnifying-glass clickable-icon"
          @click="performSearch"
        ></i>
        <input
          type="text"
          v-model="searchTerm"
          placeholder="세부 카테고리 검색"
        />
      </div>
    </div>
    <div class="sub-grid-container" v-if="filteredChildCategories.length">
      <div
        class="sub-grid-item h-txt h-transparent-lg"
        v-for="childCategory in filteredChildCategories"
        :key="childCategory.jobCode"
        @click="clickedCategory(childCategory)"
      >
        {{ childCategory.jobName }}
      </div>
    </div>
  </div>
</template>

<script setup>
import { computed, ref } from "vue";

const props = defineProps({
  category: Object,
});

const searchTerm = ref("");

const filteredChildCategories = computed(() => {
  if (!searchTerm.value) {
    return props.category.child;
  }

  return props.category.child.filter((child) =>
    child.jobName.toLowerCase().includes(searchTerm.value.toLowerCase())
  );
});

const emits = defineEmits(["select"]);

const clickedCategory = (childCategory) => {
  emits("select", {
    jobCode: childCategory.jobCode,
    jobName: childCategory.jobName,
  });
};
</script>

<style scoped>
.category-container {
  padding: 0 10px 0 20px;
}
.category-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-bottom: 20px;
}
.category-header h2 {
  color: var(--main-blue);
}
.category-header .search-bar {
  padding: 10px 0;
  border-bottom: 1px solid var(--border-gray);
}
.search-bar input {
  padding: 0;
  font-size: 16px;
  border: none;
  border-radius: 0px;
  text-align: right;
}

.sub-grid-container {
  display: grid;
  grid-template-columns: repeat(8, 1fr);
  gap: 5px;
}

.sub-grid-item {
  border: 1px solid var(--border-gray);
  border-radius: 5px;
  padding: 10px;
  cursor: pointer;
}
.sub-grid-item:active {
  background-color: rgb(104, 128, 255, 0.2);
}
</style>
