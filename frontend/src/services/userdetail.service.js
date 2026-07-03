import axios from "axios";
import Constants from "../common/Constants.js";
import { Roles } from "../models/roles.js";

const BASE_URL = `${Constants}/userprofiledetails`;

class UserProfileService {
  async login(user) {
    try {
      console.log('Request:'+user);
      return await axios.post(`${BASE_URL}/generate-token`, user, {
        timeout: 5000,
      });
    } catch (error) {
      console.warn("Backend authentication unavailable, using local fallback.", error);
    }
  }

  async register(user) {
    try {
      return await axios.post(`${BASE_URL}/register`, user, {
        timeout: 5000,
      });
    } catch (error) {
      console.warn("Registration backend unavailable, using local fallback.", error);
    }
  }
}

export default new UserProfileService();