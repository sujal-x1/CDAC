import { lazy, Suspense, useState } from "react";
import Footer from "./components/Footer";
import Header from "./components/Header";

const CustomerList = lazy(() => import("./components/CustomerList"));

function App() {
  const [page, setPage] = useState("home");
  const [user, setUser] = useState("");
  const [username, setUsername] = useState("");
  const [loginError, setLoginError] = useState("");

  function handleLogin(event) {
    event.preventDefault();
    const normalizedUsername = username.trim().toUpperCase();
    if (!normalizedUsername) {
      setLoginError("Enter a username to continue.");
      return;
    }
    setUser(normalizedUsername);
    setUsername("");
    setLoginError("");
    setPage(normalizedUsername === "VITA" ? "customers" : "home");
  }

  function handleLogout() {
    setUser("");
    setPage("home");
  }

  return (
    <div className="app-shell">
      <Header page={page} user={user} onNavigate={setPage} onLogout={handleLogout} />
      <main>
        {page === "home" && (
          <section className="home-page">
            <div className="hero-copy">
              <p className="eyebrow">CDAC · CUSTOMER MANAGEMENT</p>
              <h1>Good relationships<br /><span>start with the details.</span></h1>
              <p className="hero-description">
                A simple, organized space to keep customer information close at hand.
                Add a record, find the right detail, and keep everything up to date.
              </p>
              <div className="hero-actions">
                {user === "VITA" ? (
                  <button className="button button-dark" type="button" onClick={() => setPage("customers")}>
                    Open customer list <span aria-hidden="true">→</span>
                  </button>
                ) : (
                  <button className="button button-dark" type="button" onClick={() => setPage("login")}>
                    Get started <span aria-hidden="true">→</span>
                  </button>
                )}
                <button className="button button-quiet" type="button" onClick={() => setPage("contact")}>
                  Contact us
                </button>
              </div>
              <div className="hero-note">
                <span className="status-dot" aria-hidden="true" />
                <span>Customer details, neatly in one place</span>
              </div>
            </div>
            <div className="hero-art" aria-hidden="true">
              <div className="art-orbit orbit-one" />
              <div className="art-orbit orbit-two" />
              <div className="art-card art-card-back">
                <span className="art-card-label">CUSTOMER PROFILE</span>
                <div className="art-line art-line-long" />
                <div className="art-line art-line-short" />
              </div>
              <div className="art-card art-card-front">
                <div className="art-avatar">R</div>
                <div>
                  <span className="art-card-label">CUSTOMER</span>
                  <strong>Raj Kumar</strong>
                  <small>Details organized</small>
                </div>
                <span className="art-check">✓</span>
              </div>
              <div className="art-sparkle">✳</div>
            </div>
            <div className="home-bottom">
              <div><span className="home-bottom-number">01</span><span>Keep customer records together</span></div>
              <div><span className="home-bottom-number">02</span><span>Find details when you need them</span></div>
              <div><span className="home-bottom-number">03</span><span>Update information with ease</span></div>
            </div>
          </section>
        )}

        {page === "login" && (
          <section className="login-page">
            <div className="login-intro">
              <p className="eyebrow">WELCOME BACK</p>
              <h1>Sign in to<br /><span>your workspace.</span></h1>
              <p>Use your practical username to access the customer directory.</p>
            </div>
            <form className="panel login-panel" onSubmit={handleLogin}>
              <div className="login-icon" aria-hidden="true">↗</div>
              <p className="eyebrow">YOUR ACCOUNT</p>
              <h2>Log in</h2>
              <label className="field">
                <span>Username</span>
                <input
                  autoFocus
                  autoComplete="username"
                  placeholder="Enter your username"
                  value={username}
                  onChange={(event) => {
                    setUsername(event.target.value);
                    setLoginError("");
                  }}
                  required
                />
              </label>
              {loginError && <p className="form-error" role="alert">{loginError}</p>}
              <button className="button button-dark login-submit" type="submit">
                Continue <span aria-hidden="true">→</span>
              </button>
              <p className="login-hint">For customer access, sign in as VITA.</p>
            </form>
          </section>
        )}

        {page === "contact" && (
          <section className="contact-page">
            <div className="contact-heading">
              <p className="eyebrow">WE’RE HERE TO HELP</p>
              <h1>Contact us</h1>
              <p>Get in touch with the Authorised Training Centre.</p>
            </div>
            <div className="contact-card">
              <div className="contact-card-mark" aria-hidden="true">V</div>
              <div className="contact-details">
                <p className="eyebrow">AUTHORISED TRAINING CENTRE</p>
                <h2>Vidyanidhi Education Complex</h2>
                <address>
                  5th Floor, Vidyanidhi Education Complex,<br />
                  Vidyanidhi Road, Juhu Scheme,<br />
                  Andheri (W), Mumbai 400 049, India
                </address>
                <div className="contact-links">
                  <a href="tel:9029435311">9029435311</a>
                  <a href="tel:9324095272">9324095272</a>
                  <a href="tel:9987062416">9987062416</a>
                  <a href="mailto:training@vidyanidhi.com">training@vidyanidhi.com</a>
                </div>
              </div>
              <span className="contact-card-number" aria-hidden="true">01</span>
            </div>
          </section>
        )}

        {page === "customers" && user === "VITA" && (
          <Suspense
            fallback={
              <section className="customers-page" role="status" aria-live="polite">
                <div className="empty-state">
                  <span className="loader" aria-hidden="true" />
                  <p>Opening customer directory...</p>
                </div>
              </section>
            }
          >
            <CustomerList user={user} />
          </Suspense>
        )}
        {page === "customers" && user !== "VITA" && (
          <section className="access-denied">
            <span className="denied-icon" aria-hidden="true">!</span>
            <p className="eyebrow">RESTRICTED AREA</p>
            <h1>Access denied</h1>
            <p>Customer operations are available only to the VITA account.</p>
            <button className="button button-dark" type="button" onClick={handleLogout}>
              Log out and try again
            </button>
          </section>
        )}
      </main>
      <Footer />
    </div>
  );
}

export default App;
