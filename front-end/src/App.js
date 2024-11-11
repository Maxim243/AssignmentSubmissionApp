import logo from "./logo.svg";
import "./App.css";

function App() {
  const requestBody = {
    username: "Maxim",
    password: "max-kors",
  };
  fetch("/api/auth/login", {
    headers: {
      "Content-Type": "application/json",
    },
    method: "POST",
    body: JSON.stringify(requestBody),
  })
    .then((responce) => Promise.all([responce.json(), responce.headers]))
    .then(([body, headers]) => {
      const authValue = headers.get("authorization");
      console.log(authValue);
      console.log(body);
    });

  return (
    <div className="App">
      <h1>Hello Max</h1>
    </div>
  );
}

export default App;
