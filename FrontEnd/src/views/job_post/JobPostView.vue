<template>

  <div class="header">
    <div class="title">
        <h1 style="margin-bottom: 0px;">취업 공고</h1>
    </div>
    <div class="search-filter">
      <SearchFilter/>
    </div>
    <div class="to-diary">
        <RouterLink class="to-diary" :to="{ name:'Home' }"><h4 style="margin-top: 0px;">스크랩 공고 모아보기</h4></RouterLink>
    </div>
    <div class="filter-search-container">
        <div class="filter">필터가 들어갑니다</div>
        <div class="search"><input type="text" class="search-bar"></div>
    </div>
    <div class="recommendation">
        <h2>사용자 맞춤 추천 채용 공고</h2>
    </div>
    <JobList/>
  </div>

</template>

<script setup>
import JobList from './components/JobList.vue';
import SearchFilter from './components/SearchFilter.vue';

</script>

<style scoped>
  .header {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    min-width: 1344px; /* Ensure the header takes full width */
    
  }

  .title {
    display: flex;
    width: 100%;
    justify-content: center;
    align-items: center;
  }

  .to-diary {
    display: flex;
    width: 100%;
    justify-content: flex-end; /* Aligns the content to the left */
  }

  .filter-search-container {
    display: grid;
    grid-template-columns: 7fr 3fr;
    width: 100%;
    text-align: center;
    gap: 10px;
    padding: 10px;  
    box-sizing: border-box; 
  }

  .filter {
    border: 1px black solid;
    border-radius: 8px;
    height: 50px;
    justify-content: center;
  }

  .search {
    border: 1px black solid;
    border-radius: 8px;
    height: 50px;
    justify-content: center;
  }

  .recommendation {
    display: flex;
    justify-content: flex-start;
    width: 100%;
    margin-bottom: 0px;
  }

  .search-bar {
    height: 40px;
    font-size: 16pt;
    background-color: aliceblue;
    border-radius: 30px;
    text-align: end;
  }

  .search-filter {
    width: 1420px;
  }
</style>