# Run Customer Management

Dependencies are already installed. You do not need to run `npm install`.

## 1. Start MongoDB

Make sure MongoDB is running. If it is installed as a Windows service, check
and start it from PowerShell:

```powershell
sc.exe query MongoDB
net start MongoDB
```

`net start` is only needed if the service is stopped, and may require
Administrator PowerShell.

## 2. Start the backend

Open a terminal in VS Code and run:

```powershell
Set-Location D:\CDAC\webTechSoln\customer-crud\server
npm start
```

Leave this terminal open. The API runs at `http://localhost:5000`.

## 3. Start the frontend

Open a second terminal and run:

```powershell
Set-Location D:\CDAC\webTechSoln\customer-crud\client
npm run dev
```

Leave this terminal open and open the local URL printed by Vite, normally
`http://localhost:5173`.

Sign in as `VITA` to access customer add, list, edit, and delete features.
The customer directory is lazy-loaded when you first open it.
