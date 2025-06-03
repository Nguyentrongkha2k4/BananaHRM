"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
<<<<<<< HEAD
exports.__esModule = true;
exports.AuthOperation = void 0;
var axios_1 = require("axios");
var interfaces_1 = require("./interfaces");
var dotenv_1 = require("dotenv");
dotenv_1["default"].config();
=======
Object.defineProperty(exports, "__esModule", { value: true });
exports.AuthOperation = void 0;
var axios_1 = require("axios");
var interfaces_1 = require("./interfaces");
var dotenv = require("dotenv");
dotenv.config();
>>>>>>> e4e486ba6b6e2b6d6b157c04c8fbc9b19f0816dd
var BASE_URL = process.env.BASE_URL;
var AuthOperation = /** @class */ (function () {
    function AuthOperation() {
        this.baseUrl = "".concat(BASE_URL, "/auth");
        this.langQuery = "lang=".concat(interfaces_1.LangVersion.vi);
    }
    // async getAdmin(limit: number, page: number, token: string) {
    //     try {
    // 		const response: AxiosResponse = await axios.get(`${this.baseUrl}/get`, {
    //             params: {limit, page},
    // 			withCredentials: true,
    //             validateStatus: status => status >= 200 && status <= 500,
    //             headers: {
    //                 Authorization: `Bearer ${token}`
    //             },
    // 		});
    // 		return {
    //             success: response.data.success,
    //             message: response.data.message,
    //             data: response.data.data,
    //             status: response.status
    //         };
    // 	} 
    // 	catch (error: any) {
    // 		console.log("Error searching accounts: ", error?.response?.data);
    //         console.error("Request that caused the error: ", error?.request);
    //         return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
    // 	}
    // }
    // public async signup(payload: SignUpPayload) {
    //     try {
    // 		const response: AxiosResponse = await axios.post(`${this.baseUrl}/signup?${this.langQuery}`, payload, {
    // 			withCredentials: true,
    //             validateStatus: status => status >= 200 && status <= 500
    // 		});
    // 		return {
    //             success: response.data.success,
    //             message: response.data.message,
    //             data: response.data.data,
    //             status: response.status
    //         };
    // 	} 
    // 	catch (error: any) {
    // 		console.log("Error signing up: ", error?.response?.data);
    //         console.error("Request that caused the error: ", error?.request);
    //         return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
    // 	}
    // }
    AuthOperation.prototype.login = function (payload) {
<<<<<<< HEAD
        var _a, _b;
=======
>>>>>>> e4e486ba6b6e2b6d6b157c04c8fbc9b19f0816dd
        return __awaiter(this, void 0, void 0, function () {
            var response, error_1;
            return __generator(this, function (_c) {
                switch (_c.label) {
                    case 0:
                        _c.trys.push([0, 2, , 3]);
<<<<<<< HEAD
                        return [4 /*yield*/, axios_1["default"].post("".concat(this.baseUrl, "/login"), payload, {
                                withCredentials: true,
                                validateStatus: function (status) { return status >= 200 && status <= 500; }
=======
                        return [4 /*yield*/, axios_1.default.post("".concat(this.baseUrl, "/login"), payload, {
                                withCredentials: true,
                                validateStatus: function (status) { return status >= 200 && status <= 500; },
>>>>>>> e4e486ba6b6e2b6d6b157c04c8fbc9b19f0816dd
                            })];
                    case 1:
                        response = _c.sent();
                        return [2 /*return*/, {
                                success: response.data.success,
                                message: response.data.message,
                                data: response.data.data,
                                status: response.status
                            }];
                    case 2:
                        error_1 = _c.sent();
                        console.log("Error searching accounts: ", (_a = error_1 === null || error_1 === void 0 ? void 0 : error_1.response) === null || _a === void 0 ? void 0 : _a.data);
                        console.error("Request that caused the error: ", error_1 === null || error_1 === void 0 ? void 0 : error_1.request);
                        return [2 /*return*/, { success: (_b = error_1 === null || error_1 === void 0 ? void 0 : error_1.response) === null || _b === void 0 ? void 0 : _b.data, request: error_1 === null || error_1 === void 0 ? void 0 : error_1.request, status: error_1.response ? error_1.response.status : null }];
                    case 3: return [2 /*return*/];
                }
            });
        });
    };
    return AuthOperation;
}());
exports.AuthOperation = AuthOperation;
// export class AdminAccountOperation {
//     private baseUrl: string;
//     private langQuery: string;
//     constructor() {
//         this.baseUrl = 'https://co3001-software-engineering-backend-hk241-m8e7.onrender.com/api/v1/internal/admin/detail/me';
//         this.langQuery = `lang=${LangVersion.vi}`;
//     }
//     setLanguage(lang: LangVersion) {
//         this.langQuery = `lang=${lang}`;
//     }
//     async getAuthenticatedInfo(token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}`, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async resetPassword(email: EmailResetPassword) {
//         try {
// 			const response: AxiosResponse = await axios.post(`${this.baseUrl}/password/reset?${this.langQuery}`, email, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async checkExist(email: CheckExistAccount) {
//         try {      
// 			const response: AxiosResponse = await axios.post(`${this.baseUrl}/check?${this.langQuery}`, email, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error.message);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     public async verifyOtpForResetPassword(payload: VerifyOtpForResetPasswordPayload) {
//         try {
// 			const response: AxiosResponse = await axios.post(`${this.baseUrl}/otp/verify?${this.langQuery}`, payload, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error verifying otp: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
// }
// export class AccountOperation {
//     private baseUrl: string;
//     private langQuery: string;
//     constructor() {
//         this.baseUrl = 'https://co3001-software-engineering-backend-hk241-m8e7.onrender.com/api/v1/users';
//         this.langQuery = `lang=${LangVersion.vi}`;
//     }
//     setLanguage(lang: LangVersion) {
//         this.langQuery = `lang=${lang}`;
//     }
//     async search(payload: SearchPayload, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.post(`${this.baseUrl}/search?${this.langQuery}`, payload, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async findOne(id: UUID, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}/search/${id}?${this.langQuery}`, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async update(id: UUID, payload: UpdateAccountPayload, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.put(`${this.baseUrl}/update/${id}?${this.langQuery}`, payload, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error updating account: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async updateAvatar(id: UUID, payload: UpdateAvatarPayload, token: string) {
//         try {
//             const formData = new FormData();
//             formData.append('avatar', payload.avatar);
// 			const response: AxiosResponse = await axios.put(`${this.baseUrl}/avatar/update/${id}?${this.langQuery}`, formData, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error updating avatar: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     // will return image url in data
//     async getAvatar(id: UUID, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}/avatar/get/${id}?${this.langQuery}`, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error getting avatar: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     // get total amount number of accounts
//     async count(token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}/count?${this.langQuery}`, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async getAuthenticatedInfo(token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}/detail`, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async resetPassword(email: EmailResetPassword) {
//         try {
// 			const response: AxiosResponse = await axios.post(`${this.baseUrl}/password/reset?${this.langQuery}`, email, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async checkExist(email: CheckExistAccount) {
//         try {      
// 			const response: AxiosResponse = await axios.post(`${this.baseUrl}/check?${this.langQuery}`, email, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error.message);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     public async verifyOtpForResetPassword(payload: VerifyOtpForResetPasswordPayload) {
//         try {
// 			const response: AxiosResponse = await axios.post(`${this.baseUrl}/otp/verify?${this.langQuery}`, payload, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error verifying otp: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
// }
// export class PaymentOperation {
//     private baseUrl: string;
//     private langQuery: string;
//     constructor() {
//         this.baseUrl = 'https://co3001-software-engineering-backend-hk241-m8e7.onrender.com/api/v1/payments';
//         this.langQuery = `lang=${LangVersion.vi}`;
//     }
//     setLanguage(lang: LangVersion) {
//         this.langQuery = `lang=${lang}`;
//     }
//     async create(a4Count: number, a3Count:number, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.post(`https://co3001-software-engineering-backend-hk241-m8e7.onrender.com/api/v1/payments/create?a4Count=${a4Count}&a3Count=${a3Count}`,{},{
//                 withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`,
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async getAll(token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`https://co3001-software-engineering-backend-hk241-m8e7.onrender.com/api/v1/payments`,{
//                 withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`,
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error get all payments: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     //for admin
//     async searchStudentByID(studentId: number, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}/student/${studentId}`,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     //for admin
//     async searchByStudent(token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}/student`,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async confirm( payload: ConfirmPayload ,token: string) {
//         try {
// 			const response: AxiosResponse = await axios.post(`https://co3001-software-engineering-backend-hk241-m8e7.onrender.com/api/v1/momo/ipn`,payload,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error updating account: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
// }
// export class PrinterOperation {
//     private baseUrl: string;
//     private langQuery: string;
//     constructor() {
//         this.baseUrl = 'https://co3001-software-engineering-backend-hk241-m8e7.onrender.com/api/v1/printers';
//         this.langQuery = `lang=${LangVersion.vi}`;
//     }
//     setLanguage(lang: LangVersion) {
//         this.langQuery = `lang=${lang}`;
//     }
//     async create(payload: any, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.post(`${this.baseUrl}`, payload, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     //get tags
//     async searchAll(token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}`,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async update(id: UUID, payload: UpdatePrinterPayload, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.put(`${this.baseUrl}/${id}`, payload, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error updating account: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async delete(id: string, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.delete(`${this.baseUrl}/${id}`, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error updating account: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
// }
// export class FileOperation {
//     private baseUrl: string;
//     private langQuery: string;
//     constructor() {
//         this.baseUrl = 'https://co3001-software-engineering-backend-hk241-m8e7.onrender.com/api/v1/files';
//         this.langQuery = `lang=${LangVersion.vi}`;
//     }
//     setLanguage(lang: LangVersion) {
//         this.langQuery = `lang=${lang}`;
//     }
//     async create(a4Count: number, a3Count:number, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.post(`${this.baseUrl}/create?a4Count=${a4Count}&a3Count=${a3Count}`, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async searchAllUserFiles(token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}/get-all`,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async searchFilesById(id: string, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}/${id}`,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async delete(id: UUID, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.delete(`${this.baseUrl}/delete/${id}?${this.langQuery}`, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error updating account: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
// }
// export class PrintJobOperation {
//     private baseUrl: string;
//     private langQuery: string;
//     constructor() {
//         this.baseUrl = 'https://co3001-software-engineering-backend-hk241-m8e7.onrender.com/api/v1/print_jobs';
//     }
//     async create(payload: PrintJobPayload, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.post(`${this.baseUrl}/create`, payload,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return {message:error?.response?.data.message, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async searchAllUserFiles(token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}/get-all`,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async searchFilesById(id: string, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}/${id}`,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
// }
// export class UserOperation {
//     private baseUrl: string;
//     private langQuery: string;
//     constructor() {
//         this.baseUrl = 'https://co3001-software-engineering-backend-hk241-m8e7.onrender.com/api/v1/users';
//         this.langQuery = `lang=${LangVersion.vi}`;
//     }
//     setLanguage(lang: LangVersion) {
//         this.langQuery = `lang=${lang}`;
//     }
//     async searchAllUser(limit: number, page: number, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}/get`,{
//                 params: {limit, page},
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async searchFilesById(id: string, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}/${id}`,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async delete(id: UUID, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.delete(`${this.baseUrl}/delete/${id}?${this.langQuery}`, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error updating account: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
// }
// export class LocationOperation {
//     private baseUrl: string;
//     private langQuery: string;
//     constructor() {
//         this.baseUrl = 'https://co3001-software-engineering-backend-hk241-m8e7.onrender.com/api/v1/locations';
//         this.langQuery = `lang=${LangVersion.vi}`;
//     }
//     setLanguage(lang: LangVersion) {
//         this.langQuery = `lang=${lang}`;
//     }
//     async create(payload: any, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.post(`${this.baseUrl}`, payload, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async searchAll(token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}`,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async searchFilesById(id: string, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}/${id}`,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async delete(id: UUID, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.delete(`${this.baseUrl}/${id}`, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error updating account: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
// }
// export class FileFormatOperation {
//     private baseUrl: string;
//     private langQuery: string;
//     constructor() {
//         this.baseUrl = 'https://co3001-software-engineering-backend-hk241-m8e7.onrender.com/api/v1/file-formats';
//         this.langQuery = `lang=${LangVersion.vi}`;
//     }
//     setLanguage(lang: LangVersion) {
//         this.langQuery = `lang=${lang}`;
//     }
//     async create(payload: any, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.post(`${this.baseUrl}`, payload, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     //get tags
//     async searchAll(token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}`,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async delete(id: string, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.delete(`${this.baseUrl}/${id}`, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error updating account: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
// }
// export class PageAllocOperation {
//     private baseUrl: string;
//     private langQuery: string;
//     constructor() {
//         this.baseUrl = 'https://co3001-software-engineering-backend-hk241-m8e7.onrender.com/api/v1/page-allocations';
//         this.langQuery = `lang=${LangVersion.vi}`;
//     }
//     setLanguage(lang: LangVersion) {
//         this.langQuery = `lang=${lang}`;
//     }
//     async insert(payload: any, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.post(`${this.baseUrl}`, payload, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async getAll(token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}`,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async getById(id: string, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.get(`${this.baseUrl}/${id}`,{
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error searching accounts: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async update(id: UUID, payload: any, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.put(`${this.baseUrl}/${id}`, payload, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error updating account: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
//     async delete(id: UUID, token: string) {
//         try {
// 			const response: AxiosResponse = await axios.delete(`${this.baseUrl}/${id}`, {
// 				withCredentials: true,
//                 validateStatus: status => status >= 200 && status <= 500,
//                 headers: {
//                     Authorization: `Bearer ${token}`
//                 },
// 			});
// 			return {
//                 success: response.data.success,
//                 message: response.data.message,
//                 data: response.data.data,
//                 status: response.status
//             };
// 		} 
// 		catch (error: any) {
// 			console.log("Error updating account: ", error?.response?.data);
//             console.error("Request that caused the error: ", error?.request);
//             return { success: error?.response?.data, request: error?.request, status: error.response ? error.response.status : null };
// 		}
//     }
// }
// // flash card
// export interface UpdatePrinterPayload {
//     name?: number;
//     brand?: string;
//     type?: string;
//     lastMaintenanceDate?: number[];
//     supportContact?: string;
//     description?: string;
//     a4RemainingPages?: number;
//     a3RemainingPages?: number;
//     status?: string;
//     location?: {
//         id?: number;
//     };
//     spso?: {
//         id?: number;
//     };
// }
