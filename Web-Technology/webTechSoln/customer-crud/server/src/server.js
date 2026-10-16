require("dotenv").config();

const mongoose = require("mongoose");
const app = require("./app");

async function startServer() {
  const port = Number(process.env.PORT || 5000);
  const mongoUri = process.env.MONGODB_URI || "mongodb://127.0.0.1:27017/customerdb";

  if (!Number.isInteger(port) || port < 1 || port > 65535) {
    throw new Error("PORT must be a valid TCP port number");
  }

  await mongoose.connect(mongoUri);
  const server = app.listen(port, () => {
    console.log(`API listening at http://localhost:${port}`);
  });

  async function stopServer() {
    server.close(async (error) => {
      if (error) {
        console.error("Error closing API server:", error);
        process.exitCode = 1;
      }

      await mongoose.disconnect();
    });
  }

  process.on("SIGINT", stopServer);
  process.on("SIGTERM", stopServer);
}

startServer().catch((error) => {
  console.error("Unable to start the API:", error.message);
  process.exitCode = 1;
});
