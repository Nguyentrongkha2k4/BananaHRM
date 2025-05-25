# 1. Base image
FROM node:18-alpine AS deps

# 2. Set working directory
WORKDIR /app

# 3. Copy only package files and install dependencies
COPY package.json package-lock.json* ./
RUN npm ci

# 4. Copy rest of the app
COPY . .

# 5. Build the Next.js app
RUN npm run build

# 6. Final image
FROM node:18-alpine AS runner

# Set working directory
WORKDIR /app

# Add node_modules from previous stage
COPY --from=deps /app/node_modules ./node_modules

# Copy built app
COPY --from=deps /app/public ./public
COPY --from=deps /app/.next ./.next
COPY --from=deps /app/package.json ./package.json

# Set environment variables (adjust as needed)
ENV NODE_ENV=production

# Start the app
CMD ["npm", "start"]
