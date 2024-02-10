import { defineStore } from "pinia";
import axios from "axios";
import { useAuthStore } from "./auth";

export const useBlogReviewStore = defineStore("blogReview", {
  state: () => ({
    myJobs: [],
  }),
  actions: {
    async getMyJobs() {
      const authStore = useAuthStore()
      await authStore.updateUserInfoFromToken()
      const config = {
        headers: {
          'Authorization': `${authStore.accessToken}`,
        },
      }
      try {
        const res = await axios.get(
          `${import.meta.env.VITE_API_BASE_URL}/myRecruit/${authStore.userInfo.sub}`, config);
        this.myJobs = res.data
      } catch (err) {
        console.error(err)
      }
    },
  },
});