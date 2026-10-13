import { useState, Suspense, lazy } from 'react'
import { Loading } from './delayforDemo.jsx'

const MarkdownPreview = lazy(() =>
  delayforDemo(import('./MarkdownPreview.jsx'))
)

function delayforDemo(promise) {
  return new Promise(resolve => {
    setTimeout(resolve, 2000)
  }).then(() => promise)
}

export default function MarkdownEditor() {
  const [showPreview, setShowPreview] = useState(false)

  return (
    <>
      <label>
        <input
          type="checkbox"
          checked={showPreview}
          onChange={e => setShowPreview(e.target.checked)}
        />
        Show Preview
      </label>

      <hr />

      {showPreview && (
        <Suspense fallback={<Loading />}>
          <h2>Preview</h2>
          <MarkdownPreview />
        </Suspense>
      )}
    </>
  )
}